package jo.secondstep.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jo.secondstep.hr.entity.Region;
import jo.secondstep.hr.repository.RegionRepository;

@Service
@Transactional
public class RegionService {
	
	@Autowired
	RegionRepository regionRepository;
	
	public List<Region> getAllRegions(){
		
		return (List<Region>) regionRepository.findAll();
	}
	
	public void addRegion(Region region) {
		
		regionRepository.save(region);
	}
	
	public void deleteRegion(Integer id) {
		
		regionRepository.deleteById(id);
	}
	
	public Region getRegion(Integer id) {
		
		return regionRepository.findById(id).get();
	}

}
