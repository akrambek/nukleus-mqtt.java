/**
 * Copyright 2016-2020 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.nukleus.mqtt.internal;

import java.util.concurrent.TimeUnit;

import org.reaktivity.nukleus.Configuration;

public class MqttConfiguration extends Configuration
{
    private static final ConfigurationDef MQTT_CONFIG;
    public static final LongPropertyDef CONNECT_TIMEOUT;
    public static final LongPropertyDef PUBLISH_TIMEOUT;
    public static final PropertyDef<String> CLIENT_ID;
    public static final IntPropertyDef SESSION_EXPIRY_INTERVAL;
    public static final BytePropertyDef MAXIMUM_QOS;
    public static final BooleanPropertyDef RETAIN_AVAILABLE;
    public static final ShortPropertyDef TOPIC_ALIAS_MAXIMUM;
    public static final BooleanPropertyDef WILDCARD_SUBSCRIPTION_AVAILABLE;
    public static final BooleanPropertyDef SUBSCRIPTION_IDENTIFIERS_AVAILABLE;
    public static final BooleanPropertyDef SHARED_SUBSCRIPTION_AVAILABLE;
    public static final BooleanPropertyDef NO_LOCAL;

    static
    {
        final ConfigurationDef config = new ConfigurationDef("nukleus.mqtt");
        PUBLISH_TIMEOUT = config.property("publish.timeout", TimeUnit.SECONDS.toSeconds(30));
        CONNECT_TIMEOUT = config.property("connect.timeout", TimeUnit.SECONDS.toSeconds(3));
        CLIENT_ID = config.property("client.id", "client");
        SESSION_EXPIRY_INTERVAL = config.property("session.expiry.interval", 0);
        MAXIMUM_QOS = config.property("maximum.qos", (byte) 0);
        RETAIN_AVAILABLE = config.property("retain.available", true);
        TOPIC_ALIAS_MAXIMUM = config.property("topic.alias.maximum", (short) 0);
        WILDCARD_SUBSCRIPTION_AVAILABLE = config.property("wildcard.subscription.available", false);
        SUBSCRIPTION_IDENTIFIERS_AVAILABLE = config.property("subscription.identifiers.available", true);
        SHARED_SUBSCRIPTION_AVAILABLE = config.property("shared.subscription.available", false);
        NO_LOCAL = config.property("no.local", false);
        MQTT_CONFIG = config;
    }

    public MqttConfiguration(
        Configuration config)
    {
        super(MQTT_CONFIG, config);
    }

    public long publishTimeout()
    {
        return PUBLISH_TIMEOUT.get(this);
    }

    public long connectTimeout()
    {
        return CONNECT_TIMEOUT.get(this);
    }

    public String clientId()
    {
        return CLIENT_ID.get(this);
    }

    public boolean retainAvailable()
    {
        return RETAIN_AVAILABLE.get(this);
    }

    public int sessionExpiryInterval()
    {
        return SESSION_EXPIRY_INTERVAL.get(this);
    }

    public byte maximumQos()
    {
        return MAXIMUM_QOS.get(this);
    }

    public short topicAliasMaximum()
    {
        return TOPIC_ALIAS_MAXIMUM.get(this);
    }

    public boolean wildcardSubscriptionAvailable()
    {
        return WILDCARD_SUBSCRIPTION_AVAILABLE.get(this);
    }

    public boolean subscriptionIdentifierAvailable()
    {
        return SUBSCRIPTION_IDENTIFIERS_AVAILABLE.get(this);
    }

    public boolean sharedSubscriptionAvailable()
    {
        return SHARED_SUBSCRIPTION_AVAILABLE.get(this);
    }

    public boolean noLocal()
    {
        return NO_LOCAL.get(this);
    }
}
