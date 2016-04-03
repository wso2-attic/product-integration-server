/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.carbon.iserver.samples.router;


import org.wso2.carbon.gateway.core.config.dsl.internal.JavaConfigurationBuilder;
import static org.wso2.carbon.gateway.core.config.dsl.internal.flow.mediators.CallMediatorBuilder.call;
import static org.wso2.carbon.gateway.core.config.dsl.internal.flow.mediators.FilterMediatorBuilder.pattern;
import static org.wso2.carbon.gateway.core.config.dsl.internal.flow.mediators.FilterMediatorBuilder.source;
import static org.wso2.carbon.gateway.inbounds.http.builder.HTTPInboundEPBuilder.context;
import static org.wso2.carbon.gateway.inbounds.http.builder.HTTPInboundEPBuilder.http;
import static org.wso2.carbon.gateway.inbounds.http.builder.HTTPInboundEPBuilder.port;
import static org.wso2.carbon.gateway.outbounds.http.builder.HTTPOutboundEPBuilder.httpOutboundEndpoint;
import static org.wso2.carbon.gateway.outbounds.http.builder.HTTPOutboundEPBuilder.uri;

/**
 * Sample Internal DSL in method 1
 */
public class MessageRouter extends JavaConfigurationBuilder {

    public IntegrationFlow configure() {

        IntegrationFlow router = integrationFlow("Message_Router");

        router.inboundEndpoint("inboundEndpoint1", http(port(7777), context("/router"))).
                   pipeline("pipeline1").
                   filter(source("$header.routeId"), pattern("r1")).
                   then(call("outboundEp1")).
                   otherwise(call("outboundEp2")).
                   respond();

        router.outboundEndpoint(httpOutboundEndpoint(
                "outboundEp1", uri("http://localhost:8280/backend1")));

        router.outboundEndpoint(httpOutboundEndpoint(
                "outboundEp2", uri("http://localhost:8280/backend2")));

        return router;

    }

}
