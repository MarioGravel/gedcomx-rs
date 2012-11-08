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
package org.gedcomx.rs;

import org.gedcomx.common.Gedcomx;
import org.gedcomx.rt.CommonModels;
import org.gedcomx.rt.rs.ResourceDefinition;
import org.gedcomx.rt.rs.ResponseCode;
import org.gedcomx.rt.rs.StatusCodes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

/**
 * The conclusions resource defines the interface for a list of conclusions that are contained by a specific resource,
 * such as a person or relationship. Some implementations may bind the conclusions resource to the same path as the
 * resource that contains the conclusions (e.g. person or relationship).
 *
 * @author Ryan Heaton
 */
@ResourceDefinition (
  name = "Conclusions",
  projectId = "gedcomx-rs",
  namespace = CommonModels.GEDCOMX_NAMESPACE,
  resourceElement = Gedcomx.class
)
public interface ConclusionsRSDefinition extends CommonRSParameters {

  public static final String REL = GEDCOMX_LINK_REL_PREFIX + "conclusions";

  /**
   * Read a conclusions of an entity.
   *
   * @return The conclusions.
   */
  @GET
  @StatusCodes ({
    @ResponseCode ( code = 200, condition = "Upon a successful read."),
    @ResponseCode( code = 204, condition = "Upon a successful query with no results."),
    @ResponseCode( code = 404, condition = "The specified entity has been moved, deleted, or otherwise not found.")
  })
  Response get();

  /**
   * Create or update conclusions.
   *
   * @param conclusions The conclusions to be created or updated.
   * @return The appropriate response.
   */
  @POST
  @StatusCodes({
    @ResponseCode ( code = 201, condition = "The creation of the conclusion was successful. Expect a location header specifying the link to the created conclusion."),
    @ResponseCode ( code = 410, condition = "If the specified person has been deleted.")
  })
  Response post(Gedcomx conclusions);
}
