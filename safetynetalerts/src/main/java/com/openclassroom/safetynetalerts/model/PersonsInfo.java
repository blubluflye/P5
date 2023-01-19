package com.openclassroom.safetynetalerts.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@Data
@Setter(onMethod_ = @SuppressFBWarnings({"EI_EXPOSE_REP2","EI_EXPOSE_REP"}))
@Getter(onMethod_ = @SuppressFBWarnings({"EI_EXPOSE_REP2","EI_EXPOSE_REP"}))
public class PersonsInfo {
	List<PersonInfo> personsInfo;
	
	public void save(List<PersonInfo> listPersonInfo) {
		this.personsInfo = List.copyOf(listPersonInfo);
	}
}
