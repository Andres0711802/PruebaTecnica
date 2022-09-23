package com.prueba.andres.rangel.buscar.activo.ms.service.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.andres.rangel.buscar.activo.ms.exception.PruebaException;
import com.prueba.andres.rangel.buscar.activo.ms.model.dto.error.ErrorDto;
import com.prueba.andres.rangel.buscar.activo.ms.model.entity.Bien;
import com.prueba.andres.rangel.buscar.activo.ms.model.entity.Tipo;
import com.prueba.andres.rangel.buscar.activo.ms.model.repository.TipoRepository;
import com.prueba.andres.rangel.buscar.activo.ms.service.BienService;


@Service
public class BienServiceImpl implements BienService{

	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private EntityManager em;
	
	@Override
	public List<Bien> buscarBien(String tipo, String fechacompra, String serial) throws PruebaException {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Bien> cq = cb.createQuery(Bien.class);
		
		Root<Bien> bien = cq.from(Bien.class);

		List<Predicate> predicates = new ArrayList<>();

		if(tipo != null && !tipo.equals("")) {
			
			Tipo tipoentity = tipoRepository.findByNombre(tipo);
			if(tipoentity == null) {
				ErrorDto error = new ErrorDto();

				error.setHttpCode("404");
				error.setHttpMessage("Bad Request");
				error.setMoreInformation("No se encontro el tipo de Bien solicitado.");
				
				throw new PruebaException(error);
			}
			predicates.add(cb.equal(bien.get("idTipo"),tipoentity.getId()));
		}

		if(fechacompra != null && !fechacompra.equals("")) {
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			Date fechaC = null;
			try {
				fechaC = formatter.parse(fechacompra);
			} catch (Exception e) {
				ErrorDto error = new ErrorDto();

				error.setHttpCode("400");
				error.setHttpMessage("Bad Request");
				error.setMoreInformation("El formato de la fecha ingresado esta errado. el formato debe ser dd-MM-yyyy.");
				
				throw new PruebaException(error);
			}
			
			predicates.add(cb.equal(bien.get("fechaCompra"),fechaC));
		}

		if(serial != null && !serial.equals("")) {
			predicates.add(cb.equal(bien.get("serial"),serial));
		}
		
		cq.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Bien> query = em.createQuery(cq);
		
		return query.getResultList();
		
	}
	

}
