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
package org.springframework.social.google.api.legacyprofile.impl;

import org.springframework.social.google.api.gdata.impl.AbstractGDataOperations;
import org.springframework.social.google.api.legacyprofile.LegacyGoogleProfile;
import org.springframework.social.google.api.legacyprofile.LegacyProfileOperations;
import org.springframework.web.client.RestTemplate;

/**
 * {@link LegacyProfileOperations} implementation.
 * @author Gabriel Axel
 *
 */
public class UserTemplate extends AbstractGDataOperations implements LegacyProfileOperations {

	public UserTemplate(RestTemplate restTemplate, boolean authorized) {
		super(restTemplate, authorized);
	}

	public LegacyGoogleProfile getUserProfile() {
		requireAuthorization();
		return restTemplate.getForObject("https://www.googleapis.com/oauth2/v2/userinfo", LegacyGoogleProfile.class);
	}

}
