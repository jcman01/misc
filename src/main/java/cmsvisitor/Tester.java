package cmsvisitor;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void attachDepdendentObjects(List<? extends CMS> listParent, List<? extends CMS> listChild) {
        AttachVisitor attachVisitor = new AttachVisitor();

        for (CMS parent : listParent) {
            for (CMS child : listChild) {
                // parent.
            }
        }
    }

    public static void main(String[] args) {
        P p = new P();
        PO po = new PO();
        POL pol = new POL();
        CC cc = new CC();

        List<P> lp = new ArrayList<P>();
        lp.add(p);
        List<PO> lpo = new ArrayList<PO>();
        lpo.add(po);
        List<POL> lpol = new ArrayList<POL>();
        lpol.add(pol);
        List<CC> lcc = new ArrayList<CC>();
        lcc.add(cc);


        attachDepdendentObjects(lp, lpo);
        attachDepdendentObjects(lp, lcc);
        attachDepdendentObjects(lpo, lpol);
    }
}
//        for (Product p : listP) {
//            Map<String, Object> parameters = new HashMap<String, Object>();
//            for (SAPContentComponent cc : listCc) {
//                parameters.put("nid", p.getNid());
//                parameters.put("ref", cc.getNid());
//
//                int i = jdbcTemplate.queryForInt(sqlCC, parameters);
//
//                if (i == 1) {
//                    p.attach(cc); (this.getContentComponents().add(item);)
//                }
//            }
//        }
