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

package org.wso2.carbon.iserver.samples.custom.logger;


import org.wso2.carbon.gateway.core.config.dsl.internal.JavaConfigurationBuilder;

/**
 * This is a sample for demonstrating custom mediator functionality
 */
public class CustomLogger extends JavaConfigurationBuilder {

    public IntegrationFlow configure() {
        // TODO: Need to rewrite with the new constructs.

//        IntegrationFlow router = integrationFlow("Custom_Logger");
//
//        router.inboundEndpoint("inboundEndpoint1", http(port(7777), context("/customLogger"))).
//                   pipeline("pipeline1").process(customLog("This is logged from Custom Mediator...!")).
//                   call("outboundEp1").respond();
//
//        router.outboundEndpoint(httpOutboundEndpoint(
//                "outboundEp1", uri("http://localhost:8280/backend1")));
//
        return null;

    }

}
