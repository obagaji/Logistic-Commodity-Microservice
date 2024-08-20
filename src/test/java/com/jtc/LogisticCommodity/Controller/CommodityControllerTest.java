package com.jtc.LogisticCommodity.Controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.jtc.LogisticCommodities.LogisticCommoditiesApplication;
import com.jtc.LogisticCommodities.LogisticCommodity.Entity.DeliveryPackage;
import com.jtc.LogisticCommodities.LogisticCommodity.Service.CommodityService;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.assertj.core.internal.bytebuddy.implementation.FixedValue.value;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(classes = LogisticCommoditiesApplication.class)
@ExtendWith(SpringExtension.class)
//@WebMvcTest
public class CommodityControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper = new ObjectMapper();

	@MockBean
	 CommodityService packageService;
	
	@MockBean
	DeliveryPackage deliveryPackage;
	
	@Test
	void testGetPackageInformation() throws Exception
	{
		DeliveryPackage deliveryPack = new DeliveryPackage();
		deliveryPackage.setPackageId(1001L);
		long packageId = 1001L;
		//item deliveryPackage.getPackageId();
		String allarea = "ikeja";
		deliveryPack.setPackageName("Iphone 18");
		//deliveryPack.setPackageWeight(24L);
		deliveryPack.setPrimaryLocation("igando");
		deliveryPack.setSecondaryLocation(allarea);
        deliveryPack.setFinalLocation("Lagos");
        deliveryPack.setPackageStatus("seccessful");
        deliveryPack.setNumberOfPackage(1);
        deliveryPack.setDeliveryPersonName("daniel");


		Mockito.when(packageService.getPackageInfo(deliveryPackage.getPackageId())).thenReturn(deliveryPack);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/packageId")
                .contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(deliveryPackage.getPackageId()));

		MvcResult mvcResult =  mockMvc.perform(requestBuilder)
                .andExpect(result -> result.getResponse().setStatus(HttpServletResponse.SC_CREATED))
				.andReturn();


	}
	
	
	
}
