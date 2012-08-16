/**
 * Copyright 2011-2012 Intellectual Reserve, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gedcomx.search;

import org.gedcomx.rt.Model;
import org.gedcomx.rt.Models;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Ryan Heaton
 */
@XmlTransient
@Models ( {
  @Model (
    id = "gxq",
    projectId = "gedcomx-rs",
    namespace = SearchModel.GEDCOMX_SEARCH_NAMESPACE,
    label = "Search Model",
    description = "The search model defines elements and types used for providing metadata about the results of a search.",
    version = "1.0"
  )
} )
public class SearchModel {

  private SearchModel() {}

  public static final String GEDCOMX_SEARCH_NAMESPACE = "http://gedcomx.org/search/v1/";
}