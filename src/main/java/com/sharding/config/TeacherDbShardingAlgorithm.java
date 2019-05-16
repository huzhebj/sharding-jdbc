package com.sharding.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created by huzhe on 2019-05-16.
 */
public class TeacherDbShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Integer> {
    @Override
    public String doEqualSharding(Collection<String> dbNames, ShardingValue<Integer> shardingValue) {
        for (String dbName : dbNames) {
            if (dbName.endsWith(shardingValue.getValue() % 3 + "")) {
                return dbName;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> dbNames, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(dbNames.size());
        for (Integer value : shardingValue.getValues()) {
            for (String db : dbNames) {
                if (db.endsWith(value % 3 + "")) {
                    result.add(db);
                }
            }
        }
        return result;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> dbNames, ShardingValue<Integer> shardingValue) {
        Collection<String> result = new LinkedHashSet<>(dbNames.size());
        Range<Integer> range = shardingValue.getValueRange();
        for (Integer i = range.lowerEndpoint(); i < range.upperEndpoint(); i++) {
            for (String each : dbNames) {
                if (each.endsWith(i % 3 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
