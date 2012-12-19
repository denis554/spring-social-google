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
package org.springframework.social.google.api.plus.person;

import java.util.List;

import org.springframework.social.google.api.query.ApiPage;

/**
 * {@link ApiPage} of {@link BasePerson}.
 * @author Gabriel Axel
 */
public class PeoplePage extends ApiPage<Person> {

	public PeoplePage() {}
	
	public PeoplePage(List<Person> items, String nextPageToken) {
		super(items, nextPageToken);
	}
}
