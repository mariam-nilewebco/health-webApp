package com.nileweb.healthwebapp.diseases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nileweb.healthwebapp.symptoms.Lookup;
import com.nileweb.healthwebapp.symptoms.Symptoms;
import com.nileweb.healthwebapp.symptoms.SymptomsRepository;

@Service
public class DiseasesService {

	@Autowired
	DiseaseRepository diseaseRepository;
	@Autowired
	SymptomsRepository symptomsRepository;
	private List<Diseases> list = new ArrayList<Diseases>();;

	public List<Diseases> findAll() {
//		System.out.println("dis.isEmpty() "+list.isEmpty());
//		if(list.isEmpty())
//			list = diseaseRepository.findAll() ;
//		 

		return diseaseRepository.findAll();
	}

	private Map<Integer, Diseases> getAllMap() {
		list = diseaseRepository.findAll();
		Map<Integer, Diseases> map = new HashMap<Integer, Diseases>();
		int[] index = { -1 };
		System.err.println(list.size());
		list.forEach(dis -> {
			map.put(++index[0], dis);
		});
		return map;
	}

	public Diseases get(Long id) {
		Diseases result = diseaseRepository.findById(id).map(dis -> {

			return dis;

		}).orElse(null);
		return result;
	}

	public Diseases addSymptoms(Long id, Lookup symptom) {
		// TODO Auto-generated method stub
		Diseases result =null;
		System.out.println("lookup.id -> "+symptom.getId());
		try {
			  result = diseaseRepository.findById(id).map(dis -> {
				Symptoms _symptom = symptomsRepository.findById(symptom.getId()).map(sym -> {
					return sym;
				}).orElse(null);
if(_symptom!=null) {
				dis.addSymptoms(_symptom);
				return diseaseRepository.save(dis);
}return null;
			}).orElse(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

//	public Object addNewSymptom(Long id, Symptoms symptom) {
//		// TODO Auto-generated method stub
//		 diseaseRepository.findById(id).map(dis -> {
//
//				symptom.addDisease(dis);
//				symptomsRepository.save(symptom);
//				return dis;
//
//			}).orElse(null);
//		return null;
//	}

	public Diseases save(Diseases disease) {
		// TODO Auto-generated method stub
		disease = diseaseRepository.save(disease);
		return disease;
	}

	private Map<Integer, Diseases> map = new HashMap<Integer, Diseases>();
	private Map<String, Object> navResult = new HashMap<String, Object>();

	public Map<String, Object> navigate(String nav, Long id) {
		// TODO Auto-generated method stub
		System.out.println("navigate 1 " + id);
		if (list.isEmpty())
			map = getAllMap();
//		  list= findAll();
		Diseases dis = map.get(0);
		try {
			int[] index = { 0 };
			System.out.println("navigate 2");
			int length = list.size();
			if (id != null) {
				map.forEach((indx, dise) -> {
					if (dise.getId() == id) {
						index[0] = indx;
					}
				});
				System.out.println("navigate 3 else " + index[0]);

			}

			switch (nav.toLowerCase()) {
			case "next":
				if (index[0] == length - 1)
					dis = map.get(index[0]);

				else
					dis = map.get(++index[0]);
				break;
			case "previous":
				if (index[0] == 0)
					dis = map.get(index[0]);

				else
					dis = map.get(--index[0]);
				break;
			case "current":
				// dis=list.get(index[0]);
				System.out.println("navigate 4");
				dis = map.get(index[0]);
			default:
				break;
			}
			if (index[0] == 0) {

				navResult.put("previous", true);
				navResult.put("next", false);
			} else if (index[0] == length - 1) {

				navResult.put("previous", false);
				navResult.put("next", true);
			} else {
				navResult.put("previous", false);
				navResult.put("next", false);
			}
			navResult.put("disease", dis);
			System.out.println("navigate 5  switch " + index[0] + " -> " + dis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("navigate Error");
			e.printStackTrace();
		}
		System.out.println("dis " + dis);
		return navResult;
	}

	public void delete(Diseases dis) {
		// TODO Auto-generated method stub
		diseaseRepository.delete(dis);
	}

}
