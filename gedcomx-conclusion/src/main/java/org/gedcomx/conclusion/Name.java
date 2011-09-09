/**
 * Copyright 2011 Intellectual Reserve, Inc.
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
package org.gedcomx.conclusion;

import org.codehaus.enunciate.XmlQNameEnumUtil;
import org.codehaus.enunciate.json.JsonName;
import org.codehaus.enunciate.qname.XmlQNameEnumRef;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import org.gedcomx.rt.XmlTypeIdResolver;
import org.gedcomx.types.NameType;
import org.gedcomx.types.Typed;
import org.gedcomx.rt.CommonNamespaces;

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.*;
import java.net.URI;
import java.util.List;

/**
 * A name conclusion.
 *
 * @author Ryan Heaton
 */
@JsonTypeInfo ( use =JsonTypeInfo.Id.CUSTOM, property = "@type")
@JsonTypeIdResolver (XmlTypeIdResolver.class)
@XmlType ( name = "Name", propOrder = { "primaryForm", "alternateForms" } )
public class Name extends Conclusion implements Typed {

  private URI type;
  private NameForm primaryForm;
  private List<NameForm> alternateForms;

  /**
   * The type of the name.
   *
   * @return The type of the name.
   */
  @XmlAttribute (namespace = CommonNamespaces.GEDCOMX_COMMON_NAMESPACE)
  @XmlQNameEnumRef (NameType.class)
  @XmlSchemaType (name = "anyURI", namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI)
  public URI getType() {
    return type;
  }

  /**
   * The type of the name.
   *
   * @param type The type of the name.
   */
  public void setType(URI type) {
    this.type = type;
  }

  /**
   * The enum referencing the known name type, or {@link org.gedcomx.types.NameType#OTHER} if not known.
   *
   * @return The enum referencing the known name type, or {@link org.gedcomx.types.NameType#OTHER} if not known.
   */
  @XmlTransient
  @JsonIgnore
  public NameType getKnownType() {
    return XmlQNameEnumUtil.fromURI(getType(), NameType.class);
  }

  /**
   * Set the name type from an enumeration of known name types.
   *
   * @param knownType The known type.
   */
  @JsonIgnore
  public void setKnownType(NameType knownType) {
    setType(XmlQNameEnumUtil.toURI(knownType));
  }

  /**
   * The primary form of the name.
   *
   * @return The primary form of the name.
   */
  public NameForm getPrimaryForm() {
    return primaryForm;
  }

  /**
   * The primary form of the name.
   *
   * @param primaryForm The primary form of the name.
   */
  public void setPrimaryForm(NameForm primaryForm) {
    this.primaryForm = primaryForm;
  }

  /**
   * Alternate forms of the name, such as the romanized form of a non-latin name.
   *
   * @return Alternate forms of the name, such as the romanized form of a non-latin name.
   */
  @XmlElement (name = "alternateForm")
  @JsonName ("alternateForms")
  @JsonProperty ("alternateForms")
  public List<NameForm> getAlternateForms() {
    return alternateForms;
  }

  /**
   * Alternate forms of the name, such as the romanized form of a non-latin name.
   *
   * @param alternateForms Alternate forms of the name, such as the romanized form of a non-latin name.
   */
  @JsonProperty ("alternateForms")
  public void setAlternateForms(List<NameForm> alternateForms) {
    this.alternateForms = alternateForms;
  }
}
