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
package org.springframework.social.google.api.gdata.contact;

import java.util.Date;

/**
 * Model class representing a Google contact group.
 * @author Gabriel Axel
 */
public class ContactGroup {

	private final String id;
	private final String name;
	private final String self;
	private final Date updated;
	
	public ContactGroup(String id, String name, String self, Date updated) {
		super();
		this.id = id;
		this.name = name;
		this.self = self;
		this.updated = updated;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSelf() {
		return self;
	}
	
	public Date getUpdated() {
		return updated;
	}
}
