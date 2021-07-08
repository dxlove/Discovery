package com.nepxion.discovery.plugin.framework.loadbalance.weight;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;

import com.nepxion.discovery.common.entity.WeightFilterEntity;
import com.nepxion.discovery.plugin.framework.adapter.PluginAdapter;
import com.nepxion.discovery.plugin.framework.context.PluginContextHolder;

public class StrategyArrayWeightRandomLoadBalance extends AbstractArrayWeightRandomLoadBalance<WeightFilterEntity> {
    private StrategyWeightRandomLoadBalanceAdapter strategyWeightRandomLoadBalanceAdapter;

    public StrategyArrayWeightRandomLoadBalance(PluginAdapter pluginAdapter, PluginContextHolder pluginContextHolder) {
        strategyWeightRandomLoadBalanceAdapter = new StrategyWeightRandomLoadBalanceAdapter(pluginAdapter, pluginContextHolder);
    }

    @Override
    public WeightFilterEntity getT() {
        return strategyWeightRandomLoadBalanceAdapter.getT();
    }

    @Override
    public int getWeight(ServiceInstance server, WeightFilterEntity weightFilterEntity) {
        return strategyWeightRandomLoadBalanceAdapter.getWeight(server, weightFilterEntity);
    }

    @Override
    public boolean checkWeight(List<ServiceInstance> serverList, WeightFilterEntity weightFilterEntity) {
        return strategyWeightRandomLoadBalanceAdapter.checkWeight(serverList, weightFilterEntity);
    }
}