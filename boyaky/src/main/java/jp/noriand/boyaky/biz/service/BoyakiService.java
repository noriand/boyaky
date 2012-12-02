package jp.noriand.boyaky.biz.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jp.noriand.boyaky.biz.domain.Boyaki;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoyakiService {
	
	@PersistenceContext(unitName = "BoyakiPU")
	private EntityManager em;

	@Transactional
	public void persist(Boyaki boyaki) {
		em.persist(boyaki);
	}

	public List<Boyaki> getBoyakiList() {
		return (List<Boyaki>) em.createNamedQuery("Boyaki.findBoyakiList",
				Boyaki.class).getResultList();
	}

}
