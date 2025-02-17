/*************************************************************************
 *                                                                       *
 *  EJBCA Community: The OpenSource Certificate Authority                *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public           *
 *  License as published by the Free Software Foundation; either         *
 *  version 2.1 of the License, or any later version.                    *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.ejbca.ui.web.admin.cainterface;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.cesecore.certificates.ca.CAInfo;
import org.cesecore.certificates.ca.catoken.CAToken;
import org.cesecore.certificates.ca.kfenroll.ProxyCaInfo;
import org.cesecore.util.SimpleTime;

import com.keyfactor.util.StringTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Wrapper class for holding CaInfo properties.
 */
public class CaInfoDto {
    
    private String caName;
    private String signatureAlgorithmParam = StringUtils.EMPTY;
    private int keySequenceFormat = StringTools.KEY_SEQUENCE_FORMAT_NUMERIC;
    private String keySequence = CAToken.DEFAULT_KEYSEQUENCE;
    private int caType = CAInfo.CATYPE_X509;
    private String caSubjectDN;
    private String currentCertProfile;
    private String defaultCertificateProfile;
    private boolean useNoConflictCertificateData;
    private String description;
    private String caSerialNumberOctetSize;
    private String caEncodedValidity;
    private boolean doEnforceUniqueSubjectDNSerialnumber;
    private boolean useCertReqHistory;
    private boolean finishUser = true; // Default
    private boolean useUserStorage = true;
    private boolean useCertificateStorage = true;
    private boolean acceptRevocationsNonExistingEntry;
    private boolean doPreProduceOcspResponses = false;
    private boolean doStoreOcspResponsesOnDemand = false;
    private String caSubjectAltName;
    private String policyId;
    private boolean useAuthorityKeyIdentifier = true; // Default in create ca page
    private boolean msCaCompatible;
    private boolean authorityKeyIdentifierCritical;
    private boolean useCrlNumber = true; // Default
    private boolean crlNumberCritical;
    private String defaultCRLDistPoint;
    private String defaultCRLIssuer;
    private String defaultOCSPServiceLocator;
    private String authorityInformationAccess = StringUtils.EMPTY; // Default
    private String certificateAiaDefaultCaIssuerUri;
    private String nameConstraintsPermitted = StringUtils.EMPTY; // Default everywhere except editca page
    private String nameConstraintsExcluded = StringUtils.EMPTY; // Default everywhere except editca page
    private String caDefinedFreshestCRL;
    private boolean useUtf8Policy = true; // Default in create CA page
    private boolean usePrintableStringSubjectDN;
    private boolean useLdapDNOrder = true; // Default in create CA page
    private boolean useCrlDistributiOnPointOnCrl;
    private boolean crlDistributionPointOnCrlCritical;
    private boolean includeInHealthCheck;
    private String sharedCmpRaSecret = StringUtils.EMPTY;
    private boolean keepExpiredOnCrl;
    private boolean usePartitionedCrl;
    private int crlPartitions;
    private int suspendedCrlPartitions;
    private String cryptoTokenIdParam = StringUtils.EMPTY;
    private String cryptoTokenCertSignKey = StringUtils.EMPTY; // Initialize to empty
    private String cryptoTokenDefaultKey = StringUtils.EMPTY; // Initialize to empty
    private String selectedKeyEncryptKey = StringUtils.EMPTY; // Initialize to empty
    private String testKey = StringUtils.EMPTY; // Initialize to empty;
    private int signedBy;
    private boolean doEnforceUniquePublickeys = true;
    private boolean doEnforceKeyRenewal = false;
    private boolean doEnforceUniqueDN = true;
    private String crlCaCrlPeriod;
    private String crlCaIssueInterval;
    private String crlCaOverlapTime;
    private String crlCaDeltaCrlPeriod;
    private boolean generateCrlUponRevocation = false;
    private boolean allowChangingRevocationReason = false;
    private boolean allowInvalidityDate = false;
    private String requestPreProcessor;
    private Map<String, List<String>> alternateCertificateChains;
    
    //cits
    private String certificateId;
    private String region;

    //proxy-ca
    private String upstreamUrl;
    private String username;
    private String password;
    private List<MutableTriple<Boolean, String, String>> headers;
    private String upstreamCa;
    private String upstreamTemplate;
    private String sansJson; // Subject Attribute Names in JSON format for Upstream CA

    public long getDeltaCrlPeriod() {
        return SimpleTime.getInstance(crlCaDeltaCrlPeriod, "0" + SimpleTime.TYPE_MINUTES).getLong();
    }

    public long getcrlOverlapTime() {
        return SimpleTime.getInstance(crlCaOverlapTime, "10" + SimpleTime.TYPE_MINUTES).getLong();
    }

    public long getCrlIssueInterval() {
        return SimpleTime.getInstance(crlCaIssueInterval, "0" + SimpleTime.TYPE_MINUTES).getLong();
    }

    public long getCrlPeriod() {
        return SimpleTime.getInstance(crlCaCrlPeriod, "1" + SimpleTime.TYPE_DAYS).getLong();
    }

    public boolean isCaTypeX509() {
        return caType == CAInfo.CATYPE_X509;
    }

    public boolean isCaTypeCVC() {
        return caType == CAInfo.CATYPE_CVC;
    }
    
    public boolean isCaTypeSsh() {
        return caType == CAInfo.CATYPE_SSH;
    }
    
    public boolean isCaTypeCits() {
        return caType == CAInfo.CATYPE_CITS;
    }

    public boolean isCaTypeProxy() {
        return caType == CAInfo.CATYPE_PROXY;
    }


    String getKeySequenceFormatAsString() {
        return String.valueOf(this.keySequenceFormat);
    }

    public Integer getCurrentCertProfileAsInteger(){
        return currentCertProfile == null ? 0 : Integer.parseInt(currentCertProfile);
    }

    public int getDefaultCertProfileId() {
        return defaultCertificateProfile == null ? 0 : Integer.parseInt(defaultCertificateProfile);
    }

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName;
    }

    public String getSignatureAlgorithmParam() {
        return signatureAlgorithmParam;
    }

    public void setSignatureAlgorithmParam(String signatureAlgorithmParam) {
        this.signatureAlgorithmParam = signatureAlgorithmParam;
    }

    public int getKeySequenceFormat() {
        return keySequenceFormat;
    }

    public void setKeySequenceFormat(int keySequenceFormat) {
        this.keySequenceFormat = keySequenceFormat;
    }

    public String getKeySequence() {
        return keySequence;
    }

    public void setKeySequence(String keySequence) {
        this.keySequence = keySequence;
    }

    public int getCaType() {
        return caType;
    }

    public void setCaType(int caType) {
        this.caType = caType;
    }

    public String getCaSubjectDN() {
        return caSubjectDN;
    }

    public void setCaSubjectDN(String caSubjectDN) {
        this.caSubjectDN = caSubjectDN;
    }

    public String getCurrentCertProfile() {
        return currentCertProfile;
    }

    public void setCurrentCertProfile(String currentCertProfile) {
        this.currentCertProfile = currentCertProfile;
    }

    public String getDefaultCertificateProfile() {
        return defaultCertificateProfile;
    }

    public void setDefaultCertificateProfile(String defaultCertificateProfile) {
        this.defaultCertificateProfile = defaultCertificateProfile;
    }

    public boolean isUseNoConflictCertificateData() {
        return useNoConflictCertificateData;
    }

    public void setUseNoConflictCertificateData(boolean useNoConflictCertificateData) {
        this.useNoConflictCertificateData = useNoConflictCertificateData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaSerialNumberOctetSize() {
        return caSerialNumberOctetSize;
    }

    public void setCaSerialNumberOctetSize(String caSerialNumberOctetSize) {
        this.caSerialNumberOctetSize = caSerialNumberOctetSize;
    }

    public String getCaEncodedValidity() {
        return caEncodedValidity;
    }

    public void setCaEncodedValidity(String caEncodedValidity) {
        this.caEncodedValidity = caEncodedValidity;
    }

    public boolean isDoEnforceUniqueSubjectDNSerialnumber() {
        return doEnforceUniqueSubjectDNSerialnumber;
    }

    public void setDoEnforceUniqueSubjectDNSerialnumber(boolean doEnforceUniqueSubjectDNSerialnumber) {
        this.doEnforceUniqueSubjectDNSerialnumber = doEnforceUniqueSubjectDNSerialnumber;
    }

    public boolean isUseCertReqHistory() {
        return useCertReqHistory;
    }

    public void setUseCertReqHistory(boolean useCertReqHistory) {
        this.useCertReqHistory = useCertReqHistory;
    }

    public boolean isFinishUser() {
        return finishUser;
    }

    public void setFinishUser(boolean finishUser) {
        this.finishUser = finishUser;
    }

    public boolean isUseUserStorage() {
        return useUserStorage;
    }

    public void setUseUserStorage(boolean useUserStorage) {
        this.useUserStorage = useUserStorage;
    }

    public boolean isUseCertificateStorage() {
        return useCertificateStorage;
    }

    public void setUseCertificateStorage(boolean useCertificateStorage) {
        this.useCertificateStorage = useCertificateStorage;
    }

    public boolean isAcceptRevocationsNonExistingEntry() {
        return acceptRevocationsNonExistingEntry;
    }

    public void setAcceptRevocationsNonExistingEntry(boolean acceptRevocationsNonExistingEntry) {
        this.acceptRevocationsNonExistingEntry = acceptRevocationsNonExistingEntry;
    }
    
    public boolean isDoPreProduceOcspResponses() {
        return doPreProduceOcspResponses;
    }
    
    public void setDoPreProduceOcspResponses(boolean preProduceOcspResponses) {
        this.doPreProduceOcspResponses = preProduceOcspResponses;
    }

    public boolean isDoStoreOcspResponsesOnDemand() {
        return doStoreOcspResponsesOnDemand;
    }

    public void setDoStoreOcspResponsesOnDemand(boolean doStoreOcspResponsesOnDemand) {
        this.doStoreOcspResponsesOnDemand = doStoreOcspResponsesOnDemand;
    }

    public String getCaSubjectAltName() {
        return caSubjectAltName;
    }

    public void setCaSubjectAltName(String caSubjectAltName) {
        this.caSubjectAltName = caSubjectAltName;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public boolean isUseAuthorityKeyIdentifier() {
        return useAuthorityKeyIdentifier;
    }

    public void setUseAuthorityKeyIdentifier(boolean useAuthorityKeyIdentifier) {
        this.useAuthorityKeyIdentifier = useAuthorityKeyIdentifier;
    }

    public boolean isMsCaCompatible() {
        return msCaCompatible;
    }

    public void setMsCaCompatible(boolean msCaCompatible) {
        if (msCaCompatible) {
            // CRL Partitions for MS Compatible CA's are handled differently.
            resetUseCrlPartitionsSettings();
        }

        this.msCaCompatible = msCaCompatible;
    }

    public boolean isAuthorityKeyIdentifierCritical() {
        return authorityKeyIdentifierCritical;
    }

    public void setAuthorityKeyIdentifierCritical(boolean authorityKeyIdentifierCritical) {
        this.authorityKeyIdentifierCritical = authorityKeyIdentifierCritical;
    }

    public boolean isUseCrlNumber() {
        return useCrlNumber;
    }

    public void setUseCrlNumber(boolean useCrlNumber) {
        this.useCrlNumber = useCrlNumber;
    }

    public boolean isCrlNumberCritical() {
        return crlNumberCritical;
    }

    public void setCrlNumberCritical(boolean crlNumberCritical) {
        this.crlNumberCritical = crlNumberCritical;
    }

    public String getDefaultCRLDistPoint() {
        return defaultCRLDistPoint;
    }

    public void setDefaultCRLDistPoint(String defaultCRLDistPoint) {
        this.defaultCRLDistPoint = defaultCRLDistPoint;
    }

    public String getDefaultCRLIssuer() {
        return defaultCRLIssuer;
    }

    public void setDefaultCRLIssuer(String defaultCRLIssuer) {
        this.defaultCRLIssuer = defaultCRLIssuer;
    }

    public String getDefaultOCSPServiceLocator() {
        return defaultOCSPServiceLocator;
    }

    public void setDefaultOCSPServiceLocator(String defaultOCSPServiceLocator) {
        this.defaultOCSPServiceLocator = defaultOCSPServiceLocator;
    }

    public String getAuthorityInformationAccess() {
        return authorityInformationAccess;
    }

    public void setAuthorityInformationAccess(String authorityInformationAccess) {
        this.authorityInformationAccess = authorityInformationAccess;
    }

    public String getCertificateAiaDefaultCaIssuerUri() {
        return certificateAiaDefaultCaIssuerUri;
    }

    public void setCertificateAiaDefaultCaIssuerUri(String certificateAiaDefaultCaIssuerUri) {
        this.certificateAiaDefaultCaIssuerUri = certificateAiaDefaultCaIssuerUri;
    }

    public String getNameConstraintsPermitted() {
        return nameConstraintsPermitted;
    }

    public void setNameConstraintsPermitted(String nameConstraintsPermitted) {
        this.nameConstraintsPermitted = nameConstraintsPermitted;
    }

    public String getNameConstraintsExcluded() {
        return nameConstraintsExcluded;
    }

    public void setNameConstraintsExcluded(String nameConstraintsExcluded) {
        this.nameConstraintsExcluded = nameConstraintsExcluded;
    }

    public String getCaDefinedFreshestCRL() {
        return caDefinedFreshestCRL;
    }

    public void setCaDefinedFreshestCRL(String caDefinedFreshestCRL) {
        this.caDefinedFreshestCRL = caDefinedFreshestCRL;
    }

    public boolean isUseUtf8Policy() {
        return useUtf8Policy;
    }

    public void setUseUtf8Policy(boolean useUtf8Policy) {
        this.useUtf8Policy = useUtf8Policy;
    }

    public boolean isUsePrintableStringSubjectDN() {
        return usePrintableStringSubjectDN;
    }

    public void setUsePrintableStringSubjectDN(boolean usePrintableStringSubjectDN) {
        this.usePrintableStringSubjectDN = usePrintableStringSubjectDN;
    }

    public boolean isUseLdapDNOrder() {
        return useLdapDNOrder;
    }

    public void setUseLdapDNOrder(boolean useLdapDNOrder) {
        this.useLdapDNOrder = useLdapDNOrder;
    }

    public boolean isUseCrlDistributiOnPointOnCrl() {
        return useCrlDistributiOnPointOnCrl;
    }

    public void setUseCrlDistributiOnPointOnCrl(boolean useCrlDistributiOnPointOnCrl) {
        this.useCrlDistributiOnPointOnCrl = useCrlDistributiOnPointOnCrl;
    }

    public boolean isCrlDistributionPointOnCrlCritical() {
        return crlDistributionPointOnCrlCritical;
    }

    public void setCrlDistributionPointOnCrlCritical(boolean crlDistributionPointOnCrlCritical) {
        this.crlDistributionPointOnCrlCritical = crlDistributionPointOnCrlCritical;
    }

    public boolean isIncludeInHealthCheck() {
        return includeInHealthCheck;
    }

    public void setIncludeInHealthCheck(boolean includeInHealthCheck) {
        this.includeInHealthCheck = includeInHealthCheck;
    }

    public String getSharedCmpRaSecret() {
        return sharedCmpRaSecret;
    }

    public void setSharedCmpRaSecret(String sharedCmpRaSecret) {
        this.sharedCmpRaSecret = sharedCmpRaSecret;
    }

    public boolean isKeepExpiredOnCrl() {
        return keepExpiredOnCrl;
    }

    public void setKeepExpiredOnCrl(boolean keepExpiredOnCrl) {
        this.keepExpiredOnCrl = keepExpiredOnCrl;
    }

    public boolean isUsePartitionedCrl() {
        return usePartitionedCrl;
    }

    public void setUsePartitionedCrl(boolean usePartitionedCrl) {
        this.usePartitionedCrl = usePartitionedCrl;
    }

    public int getCrlPartitions() {
        return crlPartitions;
    }

    public void setCrlPartitions(int crlPartitions) {
        this.crlPartitions = crlPartitions;
    }

    public int getSuspendedCrlPartitions() {
        return suspendedCrlPartitions;
    }

    public void setSuspendedCrlPartitions(int suspendedCrlPartitions) {
        this.suspendedCrlPartitions = suspendedCrlPartitions;
    }

    public String getCryptoTokenIdParam() {
        return cryptoTokenIdParam;
    }

    public void setCryptoTokenIdParam(String cryptoTokenIdParam) {
        this.cryptoTokenIdParam = cryptoTokenIdParam;
    }

    public String getCryptoTokenCertSignKey() {
        return cryptoTokenCertSignKey;
    }

    public void setCryptoTokenCertSignKey(String cryptoTokenCertSignKey) {
        this.cryptoTokenCertSignKey = cryptoTokenCertSignKey;
    }

    public String getCryptoTokenDefaultKey() {
        return cryptoTokenDefaultKey;
    }

    public void setCryptoTokenDefaultKey(String cryptoTokenDefaultKey) {
        this.cryptoTokenDefaultKey = cryptoTokenDefaultKey;
    }

    public String getSelectedKeyEncryptKey() {
        return selectedKeyEncryptKey;
    }

    public void setSelectedKeyEncryptKey(String selectedKeyEncryptKey) {
        this.selectedKeyEncryptKey = selectedKeyEncryptKey;
    }

    public String getTestKey() {
        return testKey;
    }

    public void setTestKey(String testKey) {
        this.testKey = testKey;
    }

    public int getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(int signedBy) {
        this.signedBy = signedBy;
    }

    public boolean isDoEnforceUniquePublickeys() {
        return doEnforceUniquePublickeys;
    }

    public void setDoEnforceUniquePublickeys(boolean doEnforceUniquePublickeys) {
        this.doEnforceUniquePublickeys = doEnforceUniquePublickeys;
    }

    public boolean isDoEnforceKeyRenewal() {
        return doEnforceKeyRenewal;
    }

    public void setDoEnforceKeyRenewal(boolean doEnforceKeyRenewal) {
        this.doEnforceKeyRenewal = doEnforceKeyRenewal;
    }

    public boolean isDoEnforceUniqueDN() {
        return doEnforceUniqueDN;
    }

    public void setDoEnforceUniqueDN(boolean doEnforceUniqueDN) {
        this.doEnforceUniqueDN = doEnforceUniqueDN;
    }

    public String getCrlCaCrlPeriod() {
        return crlCaCrlPeriod;
    }

    public void setCrlCaCrlPeriod(String crlCaCrlPeriod) {
        this.crlCaCrlPeriod = crlCaCrlPeriod;
    }

    public String getCrlCaIssueInterval() {
        return crlCaIssueInterval;
    }

    public void setCrlCaIssueInterval(String crlCaIssueInterval) {
        this.crlCaIssueInterval = crlCaIssueInterval;
    }

    public String getCrlCaOverlapTime() {
        return crlCaOverlapTime;
    }

    public void setCrlCaOverlapTime(String crlCaOverlapTime) {
        this.crlCaOverlapTime = crlCaOverlapTime;
    }

    public String getCrlCaDeltaCrlPeriod() {
        return crlCaDeltaCrlPeriod;
    }

    public void setCrlCaDeltaCrlPeriod(String crlCaDeltaCrlPeriod) {
        this.crlCaDeltaCrlPeriod = crlCaDeltaCrlPeriod;
    }
    
    public boolean isGenerateCrlUponRevocation() {
        return generateCrlUponRevocation;
    }
    
    public void setGenerateCrlUponRevocation(boolean generate) {
        generateCrlUponRevocation = generate;
    }

    public boolean isAllowChangingRevocationReason() {
        return allowChangingRevocationReason;
    }

    public void setAllowChangingRevocationReason(boolean allowChangingRevocationReason) {
        this.allowChangingRevocationReason = allowChangingRevocationReason;
    }

    public boolean isAllowInvalidityDate() {
        return allowInvalidityDate;
    }

    public void setAllowInvalidityDate(boolean allowInvalidityDate) {
        this.allowInvalidityDate = allowInvalidityDate;
    }

    public String getRequestPreProcessor() {
        return requestPreProcessor;
    }

    public void setRequestPreProcessor(String requestPreProcessor) {
        this.requestPreProcessor = requestPreProcessor;
    }
    
    public Map<String, List<String>> getAlternateCertificateChains() {
        return alternateCertificateChains;
    }

    public void setAlternateCertificateChains(Map<String, List<String>> alternateCertificateChains) {
        this.alternateCertificateChains = alternateCertificateChains;
    }

    private void resetUseCrlPartitionsSettings() {
        this.usePartitionedCrl = false;
        this.crlPartitions = 0;
        this.suspendedCrlPartitions = 0;
    }
    
    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUpstreamUrl() {
        return upstreamUrl;
    }

    public void setUpstreamUrl(String upstreamUrl) {
        this.upstreamUrl = upstreamUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MutableTriple<Boolean, String, String>> getHeaders() {
        if (headers == null) {
            headers = new ArrayList<>();
        }
        return headers;
    }

    public void setHeaders(List<MutableTriple<Boolean, String, String>> headers) {
        this.headers = headers;
    }

    public String getUpstreamCa() {
        return upstreamCa;
    }

    public void setUpstreamCa(String upstreamCa) {
        this.upstreamCa = upstreamCa;
    }

    public String getUpstreamTemplate() {
        return upstreamTemplate;
    }

    public void setUpstreamTemplate(String upstreamTemplate) {
        this.upstreamTemplate = upstreamTemplate;
    }

    public String getSansJson() {
        return sansJson;
    }

    public void setSansJson(String sansJson) {
        this.sansJson = sansJson;
    }
    
    public ProxyCaInfo buildProxyCaInfo() {
        List<MutablePair<String, String>> pairs = getHeaders().stream().map(triple -> new MutablePair<String, String>(triple.getMiddle(), triple.getRight())).collect(Collectors.toList());
        ProxyCaInfo proxyCaInfo = new ProxyCaInfo.ProxyCaInfoBuilder()
            .setCaId(getCaSubjectDN().hashCode())
            .setName(getCaName())
            .setSubjectDn(getCaSubjectDN())
            .setEnrollWithCsrUrl(getUpstreamUrl())
            .setHeaders(pairs)
            .setUsername(getUsername())
            .setPassword(getPassword())
            .setCa(getUpstreamCa())
            .setTemplate(getUpstreamTemplate())
            .setSans(getSansJson())
            .build();

        return proxyCaInfo;
    }
}

