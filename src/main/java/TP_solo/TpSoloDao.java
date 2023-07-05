package TP_solo;


import java.util.HashMap;
import java.util.Map;

import fr.TP_Pojo.Pojo;
import jakarta.ejb.Stateless;

@Stateless
public class TpSoloDao {

	
		
		private Map<Integer, TPSolo> tps = new HashMap<>();
		
		public TpSoloDao() {
			TPSolo tp1 = new TPSolo();
			tp1.setId(1);
			tp1.setName("Hey!");
			tp1.setValid(Boolean.TRUE);
			this.tps.put(tp1.getId(), tp1);
			
			TPSolo tp2 = new TPSolo();
			tp2.setId(2);
			tp2.setName("Hé bien!");
			tp1.setValid(Boolean.FALSE);
			this.tps.put(tp2.getId(), tp2);

			TPSolo tp3 = new TPSolo();
			tp3.setId(3);
			tp3.setName("Voilà un POJO");
			tp1.setValid(Boolean.TRUE);
			this.tps.put(tp3.getId(), tp3);
		}

	
		public TPSolo getTPSolo(Integer id) {
			return this.tps.get(id);
		}
		
	}
	

	
	
	

