package com.emsi.patientsmvc.web;

import com.emsi.patientsmvc.entities.patient;
import com.emsi.patientsmvc.repositories.patientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private patientRepository patientRepository;

    @GetMapping(path="/index")
    public String patients(Model model ,
                          @RequestParam(name="page", defaultValue="0") int page ,
                          @RequestParam(name="size", defaultValue="5")int size ,
                          @RequestParam(name="keyword", defaultValue = "") String keyword

    ){
        Page<patient> pagePatients=patientRepository.findByNomContains(keyword , PageRequest.of(page,size));
        model.addAttribute( "ListPatients", pagePatients.getContent()) ;
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute( "keyword", keyword);

        return "patients";
    }
     @GetMapping("/delete")
      public String delete(Long id , String keyword , int page) {
         patientRepository.deleteById(id);
         return "redirect:/index?page="+page+"&keyword="+keyword;
     }
    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }
    @GetMapping("/patients")
    @ResponseBody
            public List<patient> lisPatients(){

            return patientRepository.findAll();
            }


}