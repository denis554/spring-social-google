/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.google.api.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 * Jackson {@link JsonDeserializer} that converts a camel case string to 
 * capital underscored string and finds the enum value with that name.
 * @author Gabriel Axel
 *
 * @param <T> enum type
 */
public abstract class ApiEnumDeserializer<T extends Enum<?>> extends JsonDeserializer<T> {

	private final Class<T> type;
	
	public ApiEnumDeserializer(Class<T> type) {
		this.type = type;
	}
	
	@Override
	public T deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {

		String camelCase = jp.getText();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < camelCase.length(); i++) {
			char c = camelCase.charAt(i);
			if(Character.isUpperCase(c)) {
				sb.append('_').append(c);
			} else {
				sb.append(Character.toUpperCase(c));
			}
		}
		
		@SuppressWarnings({ "rawtypes" })
		T value = Enum.valueOf((Class)type, sb.toString());
		
		return value;
	}

}
