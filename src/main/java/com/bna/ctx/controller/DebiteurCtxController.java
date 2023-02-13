package com.bna.ctx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bna.ctx.model.DebiteurCtx;
import com.bna.ctx.model.requestBody;
import com.bna.ctx.service.DebiteurCtxService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DebiteurCtxController{
	
	@Autowired
	private DebiteurCtxService debiteurCtxService;
	
	/*@PostMapping("/addDebiteurCtx")
	public DebiteurCtx addDebiteurCtx() {
		return debiteurCtxService.addDebiteurCtx();
	}
		
	@ResponseBody
	@GetMapping("/getDebiteurCtxByID")
	public DebiteurCtx getDebiteurCtxById() {
		return debiteurCtxService.getDebiteurCtxById();
	}*/
	
	@ResponseBody
	@GetMapping("/getDebiteurCtxFromUrl/{urlParameter}")
	public DebiteurCtx getDebiteurCtxById(@PathVariable(value="urlParameter") int urlParameter) {
		return debiteurCtxService.getDebiteurCtxByIdfromUrl(urlParameter);
	}
	
	
    @PostMapping(value = "/getDebiteurCtx")
	public @ResponseBody DebiteurCtx getDebiteurCtx(@RequestBody requestBody rb) {
		return debiteurCtxService.getDebiteurCtxByIdfromUrl(rb.getId());
	}
    
    @PostMapping(value = "/addDebiteurCtx")
	public @ResponseBody DebiteurCtx addDebiteurCtx(@RequestBody DebiteurCtx debiteurCtx) {
    	return debiteurCtxService.addDebiteurCtxRequestBody(debiteurCtx);
	}

    
    @PostMapping(value = "/updateDebiteurCtx")
	public @ResponseBody DebiteurCtx updateDebiteurCtx(@RequestBody DebiteurCtx debiteurCtx) {
    	return debiteurCtxService.addDebiteurCtxRequestBody(debiteurCtx);
	}
    
    @PostMapping(value = "/deleteDebiteurCtx")
	public @ResponseBody DebiteurCtx deleteDebiteurCtx(@RequestBody requestBody rb) {
    	return debiteurCtxService.deleteDebiteurCtx(rb.getId());
	}
    
    @ResponseBody
    @GetMapping(value = "/getAllDebiteur")
	public List<DebiteurCtx> getAllDebiteur() {
		return debiteurCtxService.getAllDebuteurOuvert();
	}
    
    @ResponseBody
    @GetMapping(value = "/getDebiteurByRisque/{urlParameter}")
	public DebiteurCtx getDebiteurByRisque(@PathVariable(value="urlParameter") int urlParameter) {
		return debiteurCtxService.getDebiteurCtxByRisque(urlParameter);
	}
}
