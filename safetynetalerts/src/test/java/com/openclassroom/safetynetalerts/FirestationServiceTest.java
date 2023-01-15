package com.openclassroom.safetynetalerts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.openclassroom.safetynetalerts.model.Firestation;
import com.openclassroom.safetynetalerts.repository.FirestationRepository;
import com.openclassroom.safetynetalerts.service.FirestationService;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;

@ExtendWith(MockitoExtension.class)
public class FirestationServiceTest {

	 @InjectMocks
	private FirestationService firestationService;
	 @Mock
	private static FirestationRepository firestationRepository;
	
	Firestation firestation;
	
	@BeforeAll
	 private static void setUp() {
	}
	
	@BeforeEach
	private void setUpPerTest() {
		firestation = new Firestation();
		String address = "5 rue du bourg";
		firestation.setAddress(address);
		firestation.setStation(1);
	}
	
	@Test
	void addFirestation() {
		given(firestationRepository.add(firestation)).willReturn(firestation);
		Firestation result = firestationService.add(firestation);
		assertThat(result).isNotNull();
	}
	
	@Test
	void updateFirestation() {
		given(firestationRepository.update(firestation.getAddress(), firestation.getStation())).willReturn(firestation);
		Firestation result = firestationService.update(firestation.getAddress(), firestation.getStation());
		//check result
		assertThat(result).isNotNull();
	}
	
	@Test
	void deleteFirestation() {
		willDoNothing().given(firestationRepository).delete(firestation.getAddress(),firestation.getStation());
		firestationService.delete(firestation.getAddress(),firestation.getStation());
		verify(firestationRepository, times(1)).delete(firestation.getAddress(),firestation.getStation());
	}
}
