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
package org.springframework.social.google.api.plus.query.impl;

import static org.springframework.util.StringUtils.hasText;

import org.springframework.social.google.api.plus.impl.AbstractGooglePlusOperations;
import org.springframework.social.google.api.plus.query.PlusPage;
import org.springframework.social.google.api.plus.query.PlusQueryBuilder;
import org.springframework.social.google.api.query.QueryBuilder;
import org.springframework.social.google.api.query.impl.QueryBuilderImpl;

/**
 * Abstract superclass for {@link QueryBuilder} implementations that query Google+.
 * @author Gabriel Axel
 * @param <Q> {@link QueryBuilder} type
 * @param <T> Model type
 */
public class PlusQueryBuilderImpl<Q extends PlusQueryBuilder<?, T>, T extends PlusPage<?>> extends QueryBuilderImpl<Q, T> implements PlusQueryBuilder<Q, T> {

	private final Class<T> type;
	private final AbstractGooglePlusOperations operations;

	private String text;
	private String pageToken;
		
	public PlusQueryBuilderImpl(String feedUrl, Class<T> type, AbstractGooglePlusOperations operations) {
		super(feedUrl);
		this.type = type;
		this.operations = operations;
	}
	
	@Override
	public Q searchFor(String text) {
		this.text = text;
		return castThis();
	}
	
	@Override
	public Q fromPage(String pageToken) {
		this.pageToken = pageToken;
		return castThis();
	}
	
	@Override
	protected StringBuilder build() {
		
		StringBuilder sb = super.build();
		
		if(hasText(text)) {
			appendQueryParam(sb, "query", text);
		}
		
		if(hasText(pageToken)) {
			appendQueryParam(sb, "pageToken", pageToken);
		}
		
		return sb;
	}

	@Override
	public T getPage() {
		return operations.getPage(build().toString(), type);
	}

}
