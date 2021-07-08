package com.nepxion.discovery.plugin.example.gateway.impl;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.client.ServiceInstance;

import com.nepxion.discovery.plugin.framework.listener.loadbalance.AbstractLoadBalanceListener;

// 当目标服务的元数据中的Group为mygroup2，禁止被本服务负载均衡
public class MyLoadBalanceListener extends AbstractLoadBalanceListener {
    @Override
    public void onGetServers(String serviceId, List<? extends ServiceInstance> servers) {
        Iterator<? extends ServiceInstance> iterator = servers.iterator();
        while (iterator.hasNext()) {
            ServiceInstance server = iterator.next();
            String group = pluginAdapter.getServerGroup(server);
            if (StringUtils.equals(group, "mygroup3")) {
                iterator.remove();

                System.out.println("********** 服务名=" + serviceId + "，组名=" + group + "的服务禁止被本服务负载均衡");
            }
        }
    }

    @Override
    public int getOrder() {
        return LOWEST_PRECEDENCE - 500;
    }
}