/*******************************************************************************
 * Copyright 2012 University of Southern California
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * This code was developed by the Information Integration Group as part 
 * of the Karma project at the Information Sciences Institute of the 
 * University of Southern California.  For more information, publications, 
 * and related projects, please see: http://www.isi.edu/integration
 ******************************************************************************/

package edu.isi.karma.service;

import java.util.ArrayList;
import java.util.List;


public class Response {
	private String type;
	private int code;
	private String stream;
	private Table table;
	private List<Param> params;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
		buildParamListFromTable();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<Param> getParams() {
		return this.params;
	}
	private void buildParamListFromTable() {
		this.params = new ArrayList<Param>();
		if (table == null)
			return;
		for (Param p : table.getHeaders()) {
			this.params.add(new Param(p));
		}
	}
}