package com.eviware.soapui;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.eviware.soapui.impl.protection.ProtectionLicense;
import com.eviware.soapui.impl.wsdl.actions.support.OpenUrlAction;
import com.eviware.soapui.lic.LicenseType;
import com.eviware.soapui.support.Tools;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.preferences.UserPreferences;
import com.eviware.x.form.XFormDialog;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.smardec.license4j.License;

public class LicenseHandling {
	static boolean a = false;

	private static boolean b = false;
	private static boolean c = false;
	private static LicenseUserInteractionHandler d = new DefaultLicenseUserInteractionHandler();
	private static LicenseData e = new LicenseData(xxxxx());
	private static LicenseType f;
	private static boolean g;

	static void a() {
		a(false);
	}

	static void a(boolean paramBoolean) {

	}

	public static LicenseData getExistingLicenseData() {
		return e;
	}

	@SuppressWarnings("deprecation")
	public static License xxxxx(){
		License l = new License();
		l.addFeature("organization", "yisufuyou-org");
		l.addFeature("name", "yisufyou-name");
		l.addFeature("type", LicenseType.PROFESSIONAL.name());
		Date d = new Date();
		d.setYear(2114);
		l.addFeature("expiration", d);
		l.addFeature("id", "yisufuyou-id");
		return l;
	}
	
	
	public static LicenseData loadLicense(InputStream paramInputStream) {
		return e;
	}

	public static OpenUrlAction createBuyLicenseAction() {
		return new OpenUrlAction("Buy License",
				"http:// www.soapui.org /buypro");
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

	public static LicenseInstallationStatus installTestRunnerLicense(
			File paramFile) {
		return ProtectionLicense.installTestRunnerLicense(paramFile, e);
	}

	static boolean a(File paramFile) {
    return true;
  }

	public static boolean isRenewable() {
		return true;
	}

	private static boolean g() {
		return (f == null)
				&& (new UserPreferences().getInstallationType() == -1);
	}

	private static void h() {
		if (UISupport
				.confirm(
						"Trials cannot be activated when you have previously installed a SoapUI Pro license.\nDo you want to get more information about purchasing a SoapUI license?",
						"Trial could not be activated ")) {
			d.showUrlInExternalBrowser("http://www.soapui.org/Licenses/license-info");
		}
	}

	private static boolean i() {
		return UISupport.confirmExtendedInfo("Confirm SoapUI License",
				"Please read and confirm license below", b(), new Dimension(
						600, 500));
	}

	static String b() {
		try {
			InputStream localInputStream = SoapUIPro.class.getResource(
					"/com/eviware/soapui/resources/conf/SoapUI-license.txt")
					.openStream();

			BufferedReader localBufferedReader = new BufferedReader(
					new InputStreamReader(localInputStream, "UTF-8"));
			StringBuilder localStringBuilder;
			(localStringBuilder = new StringBuilder())
					.append("<html><body><font size=-1>");
			String str = localBufferedReader.readLine();
			while (str != null) {
				if (str.trim().length() > 0) {
					localStringBuilder.append("<p>").append(str).append("</p>");
				}

				str = localBufferedReader.readLine();
			}

			localStringBuilder.append("</font></body></html>");
			localInputStream.close();

			return localStringBuilder.toString();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	static void a(String paramString) {
		// if (ProtectionLicense.isLicenseChecked()) {
		// d.showAboutLicenseDialog();
		// return;
		// }
		//
		// if (e == null) {
		// UISupport.showInfoMessage("SoapUI Pro is running under the Courtesy license;\nall Pro-features will be disabled until a valid license is entered",
		// paramString); return;
		// }
		//
		// d.showNewLicenseInfo(paramString);
	}

	static void a(LicenseData paramLicenseData) {
		//e = paramLicenseData;
	}

	public static void setLicense(License paramLicense) {
		//e = new LicenseData(paramLicense);
	}

	private static boolean c(LicenseData paramLicenseData) {
		// Object localObject1 = new DefaultActionList();
		// Object localObject2 = new SoapUIPro.NoProLicenseAction();
		// ((ActionList)localObject1).addAction((Action)localObject2);
		// localObject1 =
		// ADialogBuilder.buildDialog(LastNonTrialLicenseForm.class,
		// (ActionList)localObject1);
		// ((SoapUIPro.NoProLicenseAction)localObject2).setDialog((XFormDialog)localObject1);
		//
		// while ((e == null) && (((XFormDialog)localObject1).show())) {
		// try {
		// localObject2 = new
		// File(((XFormDialog)localObject1).getValue("License File"));
		//
		// if ((
		// localObject2 = loadLicense(new FileInputStream((File)localObject2)))
		// .toString().equals(paramLicenseData.toString()))
		// {
		// UISupport.showInfoMessage("Please specify path to your existing ( non trial) Pro License to install the Renewal.");
		// }
		// else if (((LicenseData)localObject2).getType() == LicenseType.TRIAL)
		// {
		// UISupport.showInfoMessage("Please specify path to your existing ( non trial) Pro License to install the Renewal.");
		// }
		// else
		// return true;
		// }
		// catch (InvalidLicenseRenewalException
		// localInvalidLicenseRenewalException)
		// {
		// throw
		// (localObject2
		// = localInvalidLicenseRenewalException);
		// }
		// catch (LicenseException localLicenseException)
		// {
		// UISupport.showErrorMessage((
		// localObject2 = localLicenseException)
		// .getMessage());
		// } catch (FileNotFoundException localFileNotFoundException) {
		// UISupport.showErrorMessage("Please select a license");
		// } catch (Exception localException) {
		// UISupport.showErrorMessage(localObject2 =
		// localException);
		// }
		// }
		// return false;
		return true;
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

		if ((str1 == null) || (str1.length() == 0))
			localStringBuilder.append(str2).append(") ");
		else if ((str2 == null) || (str2.length() == 0))
			localStringBuilder.append(e.getName()).append(") ");
		else if (str1.equals(str2))
			localStringBuilder.append(e.getName()).append(") ");
		else if (str1.contains(str2))
			localStringBuilder.append(str1.replaceAll(str2, "")).append(", ")
					.append(str2).append(") ");
		else if (str2.contains(str1))
			localStringBuilder.append(str2).append(") ");
		else {
			localStringBuilder.append(str1).append(", ").append(str2)
					.append(") ");
		}

		return localStringBuilder.toString();
	}

	public static void expirationInfo() {
		// if (!a) {
		// Date localDate1 = new Date(System.currentTimeMillis() + 86400000L);
		// Date localDate2 = new Date(System.currentTimeMillis() + 2592000000L);
		// if ((e.getType() == LicenseType.TRIAL) &&
		// (e.getExpirationDate().before(localDate1)))
		// {
		// a = true;
		// if
		// (UISupport.confirm("Your SoapUI Pro Trial License will expire within 24 hours... Go Pro?",
		// "Trial License Expiring.."))
		// {
		// d.showUrlInExternalBrowser(" http://www.soapui.org/Store-Info/store-overview.html ");
		// }
		// } else if ((e.getType() != LicenseType.TRIAL) &&
		// (e.getExpirationDate().before(localDate2)))
		// {
		// a = true;
		//
		// localDate1 = getExistingLicenseData().getExpirationDate(); localDate2
		// = new Date();
		// long l;
		// int i;
		// int j = (i = (int)((l = localDate1.getTime() - localDate2.getTime())
		// / 86400000L)) > 1 ? 1 : 0; if
		// (UISupport.confirm("Your SoapUI License will expire " + (i > 0 ?
		// "in " + i + " day" + (j != 0 ? "s" : "") : "within 24 hours") +
		// " ... Renew Now?", "Professional License Expiring.."))
		// {
		// d.showUrlInExternalBrowser("http:// www.soapui.org/Licenses/upgrade");
		// Analytics.trackAction(SoapUIActions.SHOW_RENEWAL_PAGE.getActionName());
		// }
		// }
		// }
	}

	public static LicenseValidationStatus validateLicense() {
		return validateLicense(false);
	}

	public static LicenseValidationStatus validateLicense(boolean paramBoolean) {
		// Object localObject1;
		// if (ProtectionLicense.isLicenseChecked()) {
		// if (e != null)
		// {
		// if (((
		// localObject1 = e.getType()) ==
		// LicenseType.TRIAL) && (!g())) {
		// if (!paramBoolean) {
		// h();
		// }
		// return LicenseValidationStatus.TRIAL_CANT_BE_APPLIED;
		// }
		//
		// a(((LicenseType)localObject1).ordinal());
		// }
		// return LicenseValidationStatus.VALID;
		// }
		//
		// if (!(
		// localObject1 = new File(getLicensePath()))
		// .exists()) {
		// Object localObject3 = localObject1; boolean bool = paramBoolean; if
		// (d.checkLicenseExpired()) {
		// a(SoapUIActions.LICENSE_EXPIRED.getActionName(),
		// getExistingLicenseData()); j();
		// UISupport.showErrorMessage("License expired on " +
		// (ProtectionLicense.getExpireDate() != null ?
		// ProtectionLicense.getExpireDate() : " n/a "));
		// UISupport.showErrorMessage("Missing valid license..."); } g = true;
		// Object localObject2;
		// if (!bool) if (((localObject2 = ProtectionLicense.getSoapUILicense())
		// != null) && ((localObject2 = new
		// LicenseData((License)localObject2)).getType() == LicenseType.TRIAL))
		// {
		// d.showUrlInExternalBrowser("http://www.soapui.org/Licenses/thank-you-for-trying-out.html");
		// Analytics.trackAction(SoapUIActions.SHOW_TRIAL_LICENSE_INSTALLED_PAGE.getActionName());
		// } else {
		// d.showUrlInExternalBrowser("http://www.soapui.org/Licenses/thank-you-for-downloading.html");
		// Analytics.trackAction(SoapUIActions.SHOW_PRO_LICENSE_INSTALLED_PAGE.getActionName());
		// }
		// if ((
		// localObject2 = ProtectionLicense.isLicenseChecked() ?
		// LicenseValidationStatus.VALID : !a(localObject3) ?
		// LicenseValidationStatus.EXPIRED : bool ?
		// LicenseValidationStatus.EXPIRED : (!new
		// File(getProtectionLicensePath()).exists()) && ((bool) ||
		// (!a(localObject3))) ? LicenseValidationStatus.NOT_FOUND :
		// LicenseValidationStatus.UNDETERMINED) !=
		// LicenseValidationStatus.UNDETERMINED) {
		// return localObject2;
		// }
		// }
		//
		// return a(paramBoolean, (File)localObject1);
		return LicenseValidationStatus.VALID;
	}

	public static void promptUserForLicenseAgreement() {
		// ProtectionLicense.promptUserForLicenseAgreement();
	}

	public static boolean licenseAgreementIsAccepted() {
		return true;// ProtectionLicense.licenseAgreementIsAccepted();
	}

	public static void runtimeExpiration(boolean paramBoolean) {
		// if ((paramBoolean) && (!b)) {
		// b = true;
		// a(SoapUIActions.LICENSE_EXPIRED.getActionName(),
		// getExistingLicenseData());
		// if
		// (UISupport.confirm("Your license has expired.\nDo you want to select new license? \nClick NO if you want to switch to courtesy mode where all Pro features are disabled?",
		// "License Expired"))
		// {
		// if (!a(new File(getLicensePath()))) {
		// if (getExistingLicenseData().getType() == LicenseType.TRIAL) {
		// System.exit(9);
		// }
		// ProtectionLicense.invalidateLicense();
		// } else {
		// a("License updated successfully!");
		// }
		// SoapUIPro.updateFrameTitle(); return;
		// }
		//
		// if (((
		// paramBoolean = getExistingLicenseData()) == null) ||
		// (paramBoolean.getType() == LicenseType.TRIAL)) {
		// System.exit(-1);
		// }
		// ProtectionLicense.invalidateLicense();
		// try { i();
		// return; } catch (IOException localIOException) {
		// SoapUI.logError(paramBoolean =
		// localIOException);
		// }
		// }
	}

	public static void initLicenseReader() {
		// Object localObject =
		// SoapUIPro.class.getResourceAsStream("/com/eviware/soapui/resources/conf/public.keys");
		// Properties localProperties;
		// (
		// localProperties = new Properties())
		// .load((InputStream)localObject);
		//
		// LicenseManager.setPublicKey(localObject =
		// localProperties.getProperty("public"));
	}

	static boolean d() {
		// if ((validateLicense(false) != LicenseValidationStatus.VALID) || (e
		// == null)) {
		// if (ProtectionLicense.isLicenseChecked()) {
		// return true;
		// }
		// if (((e != null) || (f == LicenseType.PROFESSIONAL) ? 1 : 0) != 0) {
		// SoapUIPro.courtesyModePopupInfo();
		// return i();
		// }
		// return false;
		// }
		// expirationInfo();
		return true;
	}

	static void e() {
		// if (!d())
		// System.exit(9);
	}

	public static void setExpiredLicenseType(LicenseType paramLicenseType) {
		f = LicenseType.PROFESSIONAL;// paramLicenseType;
	}

	private static class DefaultLicenseUserInteractionHandler implements
			LicenseUserInteractionHandler {
		public XFormDialog createDialog() {
//			XFormDialog d = new JWizardDialogBuilder("")
//			(localObject = new DefaultActionList()).addAction(LicenseHandling
//					.createBuyLicenseAction());
//			
//			
//			((ActionList) localObject).addAction(new OpenUrlAction(
//					"Apply for Trial", "http:// www.soapui.org /trial"));
//			(localObject = ADialogBuilder.buildDialog(LicenseForm.class,
//					(ActionList) localObject)).getFormField(
//					"###Choose license type").setValue(
//					"Browse for license file");
//			
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
//			return localObject;
			return null;
		}

		public void showUrlInExternalBrowser(String paramString) {
			Tools.openURL(paramString);
		}

		public boolean checkLicenseFile(File paramFile) {
			return ProtectionLicense.checkLicense(paramFile);
		}

		public boolean checkLicenseExpired() {
			return ProtectionLicense.checkLicenseExpired();
		}

		public void showAboutLicenseDialog() {
			ProtectionLicense.getSoapuiProtectionSupport().showAboutDialog();
		}

		public void showNewLicenseInfo(String paramString) {
			String org= LicenseHandling.e.getOrganization();
			if (org == null) {
				org = "&lt;not specified&gt;";
			}

			String str = "<html><body><div>Name: "
					+ LicenseHandling.e.getName() + "<br>Organization: "
					+ org + "<br>E-Mail: " + LicenseHandling.e.getEmail()
					+ "<br>License Type: " + LicenseHandling.e.getType()
					+ "<br>Expires: " + LicenseHandling.e.getExpirationDate()
					+ "</div></body></html>";

			UISupport.showExtendedInfo(paramString,
					"SoapUI Pro License Details", str, new Dimension(300, 250));
		}

		public LicenseType getInstalledLicenseType() {
			License localLicense = ProtectionLicense.getSoapUILicense();
			return new LicenseHandling.LicenseData(localLicense).getType();
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
			return this.a.getFeatureAsString("EMail");
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

		public final String getSalesForceId() {
			return (String) this.a.getFeature("SalesForceID");
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
					+ (isRenewal() ? " renewal" : "") + ", name=" + getName()
					+ ", email=" + getEmail() + ", organization="
					+ getOrganization() + ", expirationDate="
					+ getExpirationDate();
		}
	}

	static class ProxyBackup {
		private static ImmutableList<String> a = ImmutableList
				.copyOf(new String[] { "http.proxyHost", "http.proxyPassword",
						"http.proxyPort", "http.proxyUser",
						"http.nonProxyHosts", "http.proxySet" });

		private final Map<String, String> b = Maps.newHashMap();

		public void backup() {
//			Properties localProperties = System.getProperties();
//
//			for (Object localObject1 = a.iterator(); ((Iterator) localObject1)
//					.hasNext();) {
//				localObject2 = (String) ((Iterator) localObject1).next();
//				localObject3 = localProperties
//						.getProperty((String) localObject2);
//				this.b.put(localObject2, localObject3);
//				localProperties.remove(localObject2);
//			}
//			Object localObject2;
//			Object localObject3;
//			localObject1 = null;
//			try {
//				localObject1 = new ProxyVoleUtil().createAutoProxySearch()
//						.getProxySelector();
//			} catch (Exception localException1) {
//				SoapUI.logError(localObject2 = localException1);
//			}
//			if (localObject1 == null)
//				try {
//					(localObject2 = new ProxySearch())
//							.addStrategy(ProxySearch.Strategy.JAVA);
//					localObject1 = ((ProxySearch) localObject2)
//							.getProxySelector();
//				} catch (Exception localException2) {
//					SoapUI.logError(localObject2 = localException2);
//				}
//			if (localObject1 == null)
//				try {
//					(localObject2 = new ProxySearch())
//							.addStrategy(ProxySearch.Strategy.ENV_VAR);
//					localObject1 = ((ProxySearch) localObject2)
//							.getProxySelector();
//				} catch (Exception localException3) {
//					SoapUI.logError(localObject2 = localException3);
//				}
//			if ((PlatformUtil.getCurrentPlattform() != PlatformUtil.Platform.WIN)
//					&& (localObject1 == null)) {
//				try {
//					(localObject2 = new ProxySearch())
//							.addStrategy(ProxySearch.Strategy.BROWSER);
//					localObject1 = ((ProxySearch) localObject2)
//							.getProxySelector();
//				} catch (Exception localException4) {
//					SoapUI.logError(localObject2 = localException4);
//				}
//			}
//			if (localObject1 == null) {
//				try {
//					(localObject2 = new ProxySearch())
//							.addStrategy(ProxySearch.Strategy.OS_DEFAULT);
//					localObject1 = ((ProxySearch) localObject2)
//							.getProxySelector();
//				} catch (Exception localException5) {
//					SoapUI.logError(localObject2 = localException5);
//				}
//			}
//
//			if (localObject1 != null) {
//				localObject2 = null;
//				try {
//					localObject2 = ((ProxySelector) localObject1)
//							.select(new URI("http://activation.smartbear.com/"));
//				} catch (URISyntaxException localURISyntaxException) {
//					(localObject3 = localURISyntaxException).printStackTrace();
//				}
//				if ((localObject2 != null)
//						&& (((List) localObject2).size() > 0)) {
//					if (((localObject3 = ((Proxy) ((List) localObject2).get(0))
//							.address()) instanceof InetSocketAddress)) {
//						System.setProperty("https.proxySet", "true");
//						System.setProperty("http.proxySet", "true");
//						System.setProperty("http.proxyPort", Integer
//								.toString(((InetSocketAddress) localObject3)
//										.getPort()));
//						System.setProperty("http.proxyHost",
//								((InetSocketAddress) localObject3)
//										.getHostName());
//						System.setProperty("http.proxyUser",
//								System.getProperty("user.name"));
//					}
//				}
//			}
		}

		public void restore() {
//			Properties localProperties = System.getProperties();
//
//			for (Iterator localIterator = this.b.entrySet().iterator(); localIterator
//					.hasNext();) {
//				Map.Entry localEntry;
//				if ((localEntry = (Map.Entry) localIterator.next()).getValue() != null)
//					localProperties.setProperty((String) localEntry.getKey(),
//							(String) localEntry.getValue());
//				else
//					localProperties.remove(localEntry.getKey());
//			}
		}
	}
}