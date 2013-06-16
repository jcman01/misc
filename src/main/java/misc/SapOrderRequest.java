package misc;

import java.math.BigInteger;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;

public class SapOrderRequest {
    protected String orderNo;
    protected String businessPartner;
    protected String industrySector;
    protected String sourceSystem;
    protected String extDocumentNo;
    protected String clientAdId;
    protected String poNumber;
    protected String authorizerName;
    protected String phoneNumber;
    protected String adProofEmail;
    protected List<SapOrderRequest.ItemAd> itemAd;
    protected SapOrderRequest.CreditCard creditCard;
    public static class CreditCard {
        protected String cardType;
        protected String cardNumber;
        protected XMLGregorianCalendar cardValidTo;
        protected String cardName;
        protected String cardCvv;
    }
    public static class ItemAd {
        protected BigInteger itemNo;
        protected String itemCategory;
        protected String bookingUnit;
        protected String contentComponent;
        protected String advertiser;
        protected String promoCode;
        protected String priceGroup;
        protected String keyword;
        protected String customerGroup;
        protected Boolean webPubFlag;
        protected List<SapOrderRequest.ItemAd.ScheduleLine> scheduleLine;
        protected SapOrderRequest.ItemAd.Package _package;
        protected SapOrderRequest.ItemAd.NonPackage nonPackage;
        protected SapOrderRequest.ItemAd.AdContent adContent;
        public static class AdContent {
            protected SapOrderRequest.ItemAd.AdContent.ExchangeFormat exchangeFormat;
            protected String templateId;
            protected Boolean proofRequired;
            protected List<SapOrderRequest.ItemAd.AdContent.PanelField> panelField;
            protected String technicalId;
            protected List<SapOrderRequest.ItemAd.AdContent.AdGraphic> adGraphic;
            protected Boolean cameraCode;
            public static class AdGraphic {
                protected SapOrderRequest.ItemAd.AdContent.AdGraphic.DmsGraphic dmsGraphic;
                protected byte[] binaryGraphic;
                protected BigInteger graphicId;
                protected BigInteger imageBlockId;
                protected String colorScheme;
                protected String graphicType;
                public static class DmsGraphic {
                    protected String dmsId;
                    protected String busObjectType;
                    protected String key1;
                    protected String key2;
                    protected String clazz;
                    protected String dmsObjectType;
                    protected String dmsGraphicType;
                }
            }
            public static class ExchangeFormat {
                protected Ad ad;
            }
            public static class PanelField {
                protected String fieldName;
                protected String fieldValue;
            }
        }
        public static class NonPackage {
            protected XMLGregorianCalendar startDate;
            protected List<SapOrderRequest.ItemAd.NonPackage.AdSchedule> adSchedule;
            protected String onlineBookingUnit;
            public static class AdSchedule {
                protected XMLGregorianCalendar publicationDate;
                protected String basicBookingUnit;
            }
        }
        public static class Package {
            protected String packageId;
            protected XMLGregorianCalendar startDate;
            protected XMLGregorianCalendar endDate;
            protected Boolean optOutOnline;
            protected SapOrderRequest.ItemAd.Package.AdditionalRunDates additionalRunDates;
            public static class AdditionalRunDates {
                protected List<XMLGregorianCalendar> publicationDate;
            }
        }
        public static class ScheduleLine {
            protected BigInteger scheduleLineNo;
        }
    }
}
