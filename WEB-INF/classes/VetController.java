	package com.petclinic;

	import com.petclinic.VetDao;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.validation.BindingResult;
	import org.springframework.validation.FieldError;
	import org.springframework.validation.ObjectError;
	import javax.validation.Valid;
	import javax.servlet.http.HttpSession;
	import javax.servlet.http.HttpServletRequest;
	import org.springframework.web.servlet.ModelAndView;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import java.util.Collection;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Map;
	import java.util.Hashtable;
	import java.util.HashMap;
	import com.petclinic.Employee;
	import com.petclinic.Vet;
	import com.petclinic.VetDto;


	@Controller
	@RequestMapping("/")
	public class VetController{

		@Autowired
		VetDao vdao;

		@RequestMapping(value="/searchVet", method=RequestMethod.POST)
		public ModelAndView vetName(@ModelAttribute("vetDto") VetDto vetDto, BindingResult result, HttpSession session){

									System.out.println("in vetController entry!!!!!!!!!!!!");

			String vetName = vetDto.getVetName();
												System.out.println("in vetController entry!!!!!!!!!!!! vetName value" +vetName);

			String specialityName = vetDto.getSpecialityName();
															System.out.println("in vetController entry!!!!!!!!!!!! specialityName value" +specialityName);


			Map<Speciality, Vet> spMap = new HashMap<>();
			Map<Vet, Collection<Speciality>> vetMap = new HashMap<>();

			if(specialityName != ""){
			// speciality Name //
			Collection<Speciality> specialityColl = new ArrayList<Speciality>();
					Vet vetObject = new Vet();
			

						specialityColl = vdao.getSpeciality(specialityName);
								System.out.println("in vetController entry!!!!!!!!!!!! chk specialityColl value afetr cmng fro dao" +specialityColl.size());

						for (Speciality spObject : specialityColl )
						{
							vetObject = spObject.getVet();
							spMap.put(spObject, vetObject );

						}

											
			}
			else{

			// vetName //
						Collection<Speciality> sp = new ArrayList<Speciality>();
						Collection<Vet> vetColl = vdao.getVet(vetName);
																					
									System.out.println("in vetController entry!!!!!!!!!!!! chk vetColl value afetr cmng fro dao" +vetColl.size());


						for (Vet vet : vetColl )
						{
							sp =  vet.getSpecialities();
							System.out.println("inside controller vetName sp size check"+sp.size());
							vetMap.put(vet, sp);
						}

				
			}


			ModelAndView mv = new ModelAndView("vetsearch_speciality");
				mv.addObject("vetMap", vetMap);
				mv.addObject("spMap", spMap);
			

			System.out.println("HELLO CONTROLLER!!!!!!!!!!");
			
										return mv;

			

		}

	}


