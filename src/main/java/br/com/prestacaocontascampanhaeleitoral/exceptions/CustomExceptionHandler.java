package br.com.prestacaocontascampanhaeleitoral.exceptions;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javassist.tools.rmi.ObjectNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler({ObjectNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected ResponseEntity<Object> handleObjectNotFoundException(ObjectNotFoundException ex, WebRequest request) {
		List<FieldMessage> erros = Arrays.asList(new FieldMessage(ex.toString(), ex.getMessage()));	
		return new ResponseEntity<>(erros, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({MissingServletRequestParameterException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex, WebRequest request) {
		List<FieldMessage> erros = Arrays.asList(new FieldMessage(ex.toString(), ex.getMessage()));	
		return new ResponseEntity<>(erros, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

}

