package com.eviware.soapui;

import java.awt.Dimension;
import java.io.File;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import com.eviware.soapui.impl.protection.ProtectionLicense;
import com.eviware.soapui.impl.wsdl.actions.support.OpenUrlAction;
import com.eviware.soapui.lic.LicenseType;
import com.eviware.soapui.support.UISupport;
import com.eviware.x.form.XFormDialog;
import com.smardec.license4j.License;

public class LicenseHandling {
	
	
	static boolean a = true;

	private static LicenseUserInteractionHandler d = new DefaultLicenseUserInteractionHandler();
	private static LicenseData e;

	
	static void a() {
//		if ((new File(getProtectionLicensePath()).exists())
//				&& (!ProtectionLicense.checkLicenseExpired())
//				&& (ProtectionLicense.checkLicense())) {
//			e = new LicenseData(ProtectionLicense.getSoapUILicense());
//		}
		License l = new License();
		l.addFeature("organization", "yisufuyou-org");
		l.addFeature("name", "yisufyou-name");
		l.addFeature("type", LicenseType.PROFESSIONAL.name());
		Date d = new Date();
		d.setYear(2114);
		l.addFeature("expiration", d);
		l.addFeature("id", "yisufuyou-id");
		e = new LicenseData(l);
	}

	public static LicenseData getLicenseData() {
		License l = new License();
		l.addFeature("organization", "yisufuyou-org");
		l.addFeature("name", "yisufyou-name");
		l.addFeature("type", LicenseType.PROFESSIONAL.name());
		Date d = new Date();
		d.setYear(2114);
		l.addFeature("expiration", d);
		l.addFeature("id", "yisufuyou-id");
		return new LicenseData(l);
	}

	public static LicenseData loadLicense(InputStream paramInputStream) {
		License l = new License();
		l.addFeature("organization", "yisufuyou-org");
		l.addFeature("name", "yisufyou-name");
		l.addFeature("type", LicenseType.PROFESSIONAL.name());
		Date d = new Date();
		d.setYear(2114);
		l.addFeature("expiration", d);
		l.addFeature("id", "yisufuyou-id");
		return new LicenseData(l);
	}

	public static OpenUrlAction createBuyLicenseAction() {
		return new OpenUrlAction("Just For Fun", "http://www.guoyukun.cn");
	}

	public static String getLicensePath() {
		String str = System.getProperty("user.home") + File.separatorChar
				+ ".soapui";
		return str + File.separatorChar + "soapui.lic";
	}

	public static String getProtectionLicensePath() {
		String str = System.getProperty("user.home") + File.separatorChar
				+ ".soapui";
		return str + File.separatorChar + "soapui.key";
	}

	public static String getProtectionSecretStoragePath() {
		String str = System.getProperty("user.home") + File.separatorChar
				+ ".soapui";
		return str + File.separatorChar + "soapui.dat";
	}

	static boolean a(File paramFile) {
		return false;
	}

	static String b() {
//		InputStream localInputStream = SoapUIPro.class.getResource(
//				"/com/eviware/soapui/resources/conf/SoapUI-license.txt")
//				.openStream();
//
//		BufferedReader localBufferedReader = new BufferedReader(
//				new InputStreamReader(localInputStream, "UTF-8"));
//		StringBuilder localStringBuilder;
//		(localStringBuilder = new StringBuilder())
//				.append("<html><body><font size=-1>");
//		String str = localBufferedReader.readLine();
//		while (str != null) {
//			if (str.trim().length() > 0) {
//				localStringBuilder.append("<p>").append(str).append("</p>");
//			}
//			str = localBufferedReader.readLine();
//		}
//
//		localStringBuilder.append("</font></body></html>");
//		localInputStream.close();
//
//		return localStringBuilder.toString();
		return "bbbbb";
	}

	static void a(String paramString) {
		if (ProtectionLicense.isLicenseChecked()) {
			d.showAboutLicenseDialog();
			return;
		}

		if (e == null) {
			UISupport
					.showInfoMessage(
							"SoapUI Pro is running under the Courtesy license;\nall Pro-features will be disabled until a valid license is entered",
							paramString);
			return;
		}

		d.showNewLicenseInfo(paramString);
	}

	static void a(LicenseData paramLicenseData) {
		License l = new License();
		l.addFeature("organization", "yisufuyou-org");
		l.addFeature("name", "yisufyou-name");
		l.addFeature("type", LicenseType.PROFESSIONAL.name());
		Date d = new Date();
		d.setYear(2114);
		l.addFeature("expiration", d);
		l.addFeature("id", "yisufuyou-id");
		e = new LicenseData(l);
	}

	public static void setLicense(License paramLicense) {
		License l = new License();
		l.addFeature("organization", "yisufuyou-org");
		l.addFeature("name", "yisufyou-name");
		l.addFeature("type", LicenseType.PROFESSIONAL.name());
		Date d = new Date();
		d.setYear(2114);
		l.addFeature("expiration", d);
		l.addFeature("id", "yisufuyou-id");
		e = new LicenseData(l);
	}

	public static void clearLicenseData() {
		e = null;
	}

	static String c() {
		StringBuilder localStringBuilder = new StringBuilder();

		String str1 = e.getName();
		String str2 = e.getOrganization();

		if ((((str1 == null) || (str1.length() == 0) ? 1 : 0) & ((str2 == null)
				|| (str2.length() == 0) ? 1 : 0)) != 0) {
			return "";
		}

		if ((str1 == null) || (str1.length() == 0)) {
			localStringBuilder.append(str2).append(") ");
		} else if ((str2 == null) || (str2.length() == 0)) {
			localStringBuilder.append(e.getName()).append(") ");
		} else if (str1.equals(str2)) {
			localStringBuilder.append(e.getName()).append(") ");
		} else if (str1.contains(str2)) {
			localStringBuilder.append(str1.replaceAll(str2, "")).append(", ")
					.append(str2).append(") ");
		} else if (str2.contains(str1)) {
			localStringBuilder.append(str2).append(") ");
		} else {
			localStringBuilder.append(str1).append(", ").append(str2)
					.append(") ");
		}

		return localStringBuilder.toString();
	}

	public static void expirationInfo() {

	}

	public static boolean validateLicense() {
		return validateLicense(false);
	}

	public static boolean validateLicense(boolean paramBoolean) {
		return true;
	}

	public static void runtimeExpiration(boolean paramBoolean) {

	}

	public static void initLicenseReader() {
	}

	static boolean d() {
		// TODO; 不确定
		return true;
	}

	static void e() {
	}

	public static void setExpiredLicenseType(LicenseType paramLicenseType) {
		//
	}

	private static class DefaultLicenseUserInteractionHandler implements
			LicenseUserInteractionHandler {
		public XFormDialog createDialog() {
//			DefaultActionList localObject;
//			(localObject = new DefaultActionList()).addAction(LicenseHandling
//					.createBuyLicenseAction());
//			((ActionList) localObject).addAction(new OpenUrlAction(
//					"Apply for Trial", "http://www.eviware.com/trial"));
//			
//			(localObject = ADialogBuilder.buildDialog(LicenseForm.class,
//					(ActionList) localObject)).getFormField(
//					"###Choose license type").setValue(
//					"Browse for license file");
//			((XFormDialog) localObject).getFormField("###Choose license type")
//					.addFormFieldListener(new XFormFieldListener() {
//						public void valueChanged(
//								XFormField paramAnonymousXFormField,
//								String paramAnonymousString1,
//								String paramAnonymousString2) {
//							this.a.getFormField("License File")
//									.setEnabled(
//											!paramAnonymousString1
//													.equals("Acquire floating license from server"));
//						}
//					});
			return null;// localObject;
		}

		public void showUrlInExternalBrowser(String paramString) {
			
		}

		public boolean checkLicenseFile(File paramFile) {
			return true;
		}

		public void showAboutLicenseDialog() {
			ProtectionLicense.getSoapuiProtectionSupport().showAboutDialog();
		}

		public void showNewLicenseInfo(String paramString) {
//			if ((str = LicenseHandling.f().getOrganization()) == null) {
//				str = "&lt;not specified&gt;";
//			}
//			String str = "<html><body><div>Name: "
//					+ LicenseHandling.f.name() + "<br>Organization: "
//					+ str + "<br>E-Mail: " + LicenseHandling.f().getEmail()
//					+ "<br>License Type: " + LicenseHandling.f().getType()
//					+ "<br>Expires: " + LicenseHandling.f().getExpirationDate()
//					+ "</div></body></html>";
			String str ="<html><body><div>"+ "xxx</div></body></html>";
			UISupport.showExtendedInfo(paramString,
					"SoapUI Pro License Details", str, new Dimension(300, 250));
		}

		public LicenseType getInstalledLicenseType() {
			return LicenseType.PROFESSIONAL;
		}
	}

	public static final class LicenseData {
		private License a;

		LicenseData(License paramLicense) {
			this.a = paramLicense;
		}

		public final License getLicense() {
			return this.a;
		}

		public final String getEmail() {
			return this.a.getFeatureAsString("email");
		}

		public final String getName() {
			return this.a.getFeatureAsString("name");
		}

		public final String getOrganization() {
			return this.a.getFeatureAsString("organization");
		}

		public final Date getExpirationDate() {
			return (Date) this.a.getFeature("expiration");
		}

		public final boolean isExpired() {
			Date localDate1 = getExpirationDate();
			Date localDate2 = Calendar.getInstance().getTime();
			return localDate1.before(localDate2);
		}

		public final boolean isTooOld() {
			Date localDate = getExpirationDate();
			Calendar localCalendar;
			(localCalendar = Calendar.getInstance()).setTime(localDate);
			localCalendar.roll(2, 6);
			return localCalendar.before(Calendar.getInstance());
		}

		public final LicenseType getType() {
			String str;
			return LicenseType.valueOf(str = this.a.getFeatureAsString("type"));
		}

		public final boolean isRenewal() {
			String str;
			return ((str = this.a.getFeatureAsString("renewal")) != null)
					&& (Boolean.parseBoolean(str));
		}

		public final String getLicenseId() {
			return this.a.getFeatureAsString("id");
		}

		public final String toString() {
			return "License " + getLicenseId() + ": type=" + getType()
					+ (isRenewal() ? " RENEWAL" : "") + ", name=" + getName()
					+ ", email=" + getEmail() + ", organization="
					+ getOrganization() + ", expirationDate="
					+ getExpirationDate();
		}
	}


	static class ProxyBackup {
		
		public void backup() {
				}

		public void restore() {
		}
	}
}