package com.example.jerem.avtools;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jerem on 12/23/2016.
 */



public class TableData extends ArrayList<TableData> {

    private String arrivalTimeLocalStr;
    private String arrivalTimeZuluStr;
    private String departureTimeLocalStr;
    private String departureTimeZuluStr;
    private Integer fVFlightsRowId;
    private String flightId;
    private String flightIdIcao;
    private String regNum;
    private String acType;
    private String acDescription;
    private Integer operatorType;
    private String departureAP;
    private Object apShade;
    private String departureTime;
    private String departureTimeLocal;
    private String companyName;
    private Integer arrivalEta;
    private String arrivalTime;
    private String arrivalTimeLocal;
    private String airportDescription;
    private Object pcAbbr;
    private Object pcColor;
    private Object pcDesc;
    private Object secondaryCodes;
    private String secondaryCodeDescriptions;
    private String notes;
    private Integer efb;
    private Integer fuelCapacity;
    private String base;
    private String baseDescription;
    private Object baseShade;
    private String status;
    private Object ctuId;
    private Object fuelUpload;
    private Object comment;
    private String lat;
    private String lon;
    private Integer heading;
    private Integer altitude;
    private Integer speed;
    private Boolean hasHistory;
    private String ctuDates;
    private Object reservationId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


/**
     * No args constructor for use in serialization
     *
     */

    public TableData() {
    }


/*
     *
     * @param operatorType
     * @param acDescription
     * @param departureAP
     * @param ctuId
     * @param altitude
     * @param fuelCapacity
     * @param secondaryCodes
     * @param efb
     * @param departureTimeLocalStr
     * @param arrivalTimeLocal
     * @param flightId
     * @param airportDescription
     * @param departureTimeZuluStr
     * @param ctuDates
     * @param regNum
     * @param departureTimeLocal
     * @param secondaryCodeDescriptions
     * @param acType
     * @param lat
     * @param pcDesc
     * @param arrivalTimeLocalStr
     * @param lon
     * @param apShade
     * @param speed
     * @param status
     * @param departureTime
     * @param reservationId
     * @param fuelUpload
     * @param companyName
     * @param fVFlightsRowId
     * @param baseShade
     * @param pcColor
     * @param arrivalTime
     * @param hasHistory
     * @param base
     * @param arrivalTimeZuluStr
     * @param arrivalEta
     * @param baseDescription
     * @param comment
     * @param notes
     * @param flightIdIcao
     * @param heading
     * @param pcAbbr
     */

    public TableData(String arrivalTimeLocalStr, String arrivalTimeZuluStr, String departureTimeLocalStr, String departureTimeZuluStr, Integer fVFlightsRowId, String flightId, String flightIdIcao, String regNum, String acType, String acDescription, Integer operatorType, String departureAP, Object apShade, String departureTime, String departureTimeLocal, String companyName, Integer arrivalEta, String arrivalTime, String arrivalTimeLocal, String airportDescription, Object pcAbbr, Object pcColor, Object pcDesc, Object secondaryCodes, String secondaryCodeDescriptions, String notes, Integer efb, Integer fuelCapacity, String base, String baseDescription, Object baseShade, String status, Object ctuId, Object fuelUpload, Object comment, String lat, String lon, Integer heading, Integer altitude, Integer speed, Boolean hasHistory, String ctuDates, Object reservationId) {
        super();
        this.arrivalTimeLocalStr = arrivalTimeLocalStr;
        this.arrivalTimeZuluStr = arrivalTimeZuluStr;
        this.departureTimeLocalStr = departureTimeLocalStr;
        this.departureTimeZuluStr = departureTimeZuluStr;
        this.fVFlightsRowId = fVFlightsRowId;
        this.flightId = flightId;
        this.flightIdIcao = flightIdIcao;
        this.regNum = regNum;
        this.acType = acType;
        this.acDescription = acDescription;
        this.operatorType = operatorType;
        this.departureAP = departureAP;
        this.apShade = apShade;
        this.departureTime = departureTime;
        this.departureTimeLocal = departureTimeLocal;
        this.companyName = companyName;
        this.arrivalEta = arrivalEta;
        this.arrivalTime = arrivalTime;
        this.arrivalTimeLocal = arrivalTimeLocal;
        this.airportDescription = airportDescription;
        this.pcAbbr = pcAbbr;
        this.pcColor = pcColor;
        this.pcDesc = pcDesc;
        this.secondaryCodes = secondaryCodes;
        this.secondaryCodeDescriptions = secondaryCodeDescriptions;
        this.notes = notes;
        this.efb = efb;
        this.fuelCapacity = fuelCapacity;
        this.base = base;
        this.baseDescription = baseDescription;
        this.baseShade = baseShade;
        this.status = status;
        this.ctuId = ctuId;
        this.fuelUpload = fuelUpload;
        this.comment = comment;
        this.lat = lat;
        this.lon = lon;
        this.heading = heading;
        this.altitude = altitude;
        this.speed = speed;
        this.hasHistory = hasHistory;
        this.ctuDates = ctuDates;
        this.reservationId = reservationId;
    }

    public String getArrivalTimeLocalStr() {
        return arrivalTimeLocalStr;
    }

    public void setArrivalTimeLocalStr(String arrivalTimeLocalStr) {
        this.arrivalTimeLocalStr = arrivalTimeLocalStr;
    }

    public TableData withArrivalTimeLocalStr(String arrivalTimeLocalStr) {
        this.arrivalTimeLocalStr = arrivalTimeLocalStr;
        return this;
    }

    public String getArrivalTimeZuluStr() {
        return arrivalTimeZuluStr;
    }

    public void setArrivalTimeZuluStr(String arrivalTimeZuluStr) {
        this.arrivalTimeZuluStr = arrivalTimeZuluStr;
    }

    public TableData withArrivalTimeZuluStr(String arrivalTimeZuluStr) {
        this.arrivalTimeZuluStr = arrivalTimeZuluStr;
        return this;
    }

    public String getDepartureTimeLocalStr() {
        return departureTimeLocalStr;
    }

    public void setDepartureTimeLocalStr(String departureTimeLocalStr) {
        this.departureTimeLocalStr = departureTimeLocalStr;
    }

    public TableData withDepartureTimeLocalStr(String departureTimeLocalStr) {
        this.departureTimeLocalStr = departureTimeLocalStr;
        return this;
    }

    public String getDepartureTimeZuluStr() {
        return departureTimeZuluStr;
    }

    public void setDepartureTimeZuluStr(String departureTimeZuluStr) {
        this.departureTimeZuluStr = departureTimeZuluStr;
    }

    public TableData withDepartureTimeZuluStr(String departureTimeZuluStr) {
        this.departureTimeZuluStr = departureTimeZuluStr;
        return this;
    }

    public Integer getFVFlightsRowId() {
        return fVFlightsRowId;
    }

    public void setFVFlightsRowId(Integer fVFlightsRowId) {
        this.fVFlightsRowId = fVFlightsRowId;
    }

    public TableData withFVFlightsRowId(Integer fVFlightsRowId) {
        this.fVFlightsRowId = fVFlightsRowId;
        return this;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public TableData withFlightId(String flightId) {
        this.flightId = flightId;
        return this;
    }

    public String getFlightIdIcao() {
        return flightIdIcao;
    }

    public void setFlightIdIcao(String flightIdIcao) {
        this.flightIdIcao = flightIdIcao;
    }

    public TableData withFlightIdIcao(String flightIdIcao) {
        this.flightIdIcao = flightIdIcao;
        return this;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public TableData withRegNum(String regNum) {
        this.regNum = regNum;
        return this;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public TableData withAcType(String acType) {
        this.acType = acType;
        return this;
    }

    public String getAcDescription() {
        return acDescription;
    }

    public void setAcDescription(String acDescription) {
        this.acDescription = acDescription;
    }

    public TableData withAcDescription(String acDescription) {
        this.acDescription = acDescription;
        return this;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public TableData withOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
        return this;
    }

    public String getDepartureAP() {
        return departureAP;
    }

    public void setDepartureAP(String departureAP) {
        this.departureAP = departureAP;
    }

    public TableData withDepartureAP(String departureAP) {
        this.departureAP = departureAP;
        return this;
    }

    public Object getApShade() {
        return apShade;
    }

    public void setApShade(Object apShade) {
        this.apShade = apShade;
    }

    public TableData withApShade(Object apShade) {
        this.apShade = apShade;
        return this;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public TableData withDepartureTime(String departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    public String getDepartureTimeLocal() {
        return departureTimeLocal;
    }

    public void setDepartureTimeLocal(String departureTimeLocal) {
        this.departureTimeLocal = departureTimeLocal;
    }

    public TableData withDepartureTimeLocal(String departureTimeLocal) {
        this.departureTimeLocal = departureTimeLocal;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public TableData withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Integer getArrivalEta() {
        return arrivalEta;
    }

    public void setArrivalEta(Integer arrivalEta) {
        this.arrivalEta = arrivalEta;
    }

    public TableData withArrivalEta(Integer arrivalEta) {
        this.arrivalEta = arrivalEta;
        return this;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public TableData withArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public String getArrivalTimeLocal() {
        return arrivalTimeLocal;
    }

    public void setArrivalTimeLocal(String arrivalTimeLocal) {
        this.arrivalTimeLocal = arrivalTimeLocal;
    }

    public TableData withArrivalTimeLocal(String arrivalTimeLocal) {
        this.arrivalTimeLocal = arrivalTimeLocal;
        return this;
    }

    public String getAirportDescription() {
        return airportDescription;
    }

    public void setAirportDescription(String airportDescription) {
        this.airportDescription = airportDescription;
    }

    public TableData withAirportDescription(String airportDescription) {
        this.airportDescription = airportDescription;
        return this;
    }

    public Object getPcAbbr() {
        return pcAbbr;
    }

    public void setPcAbbr(Object pcAbbr) {
        this.pcAbbr = pcAbbr;
    }

    public TableData withPcAbbr(Object pcAbbr) {
        this.pcAbbr = pcAbbr;
        return this;
    }

    public Object getPcColor() {
        return pcColor;
    }

    public void setPcColor(Object pcColor) {
        this.pcColor = pcColor;
    }

    public TableData withPcColor(Object pcColor) {
        this.pcColor = pcColor;
        return this;
    }

    public Object getPcDesc() {
        return pcDesc;
    }

    public void setPcDesc(Object pcDesc) {
        this.pcDesc = pcDesc;
    }

    public TableData withPcDesc(Object pcDesc) {
        this.pcDesc = pcDesc;
        return this;
    }

    public Object getSecondaryCodes() {
        return secondaryCodes;
    }

    public void setSecondaryCodes(Object secondaryCodes) {
        this.secondaryCodes = secondaryCodes;
    }

    public TableData withSecondaryCodes(Object secondaryCodes) {
        this.secondaryCodes = secondaryCodes;
        return this;
    }

    public String getSecondaryCodeDescriptions() {
        return secondaryCodeDescriptions;
    }

    public void setSecondaryCodeDescriptions(String secondaryCodeDescriptions) {
        this.secondaryCodeDescriptions = secondaryCodeDescriptions;
    }

    public TableData withSecondaryCodeDescriptions(String secondaryCodeDescriptions) {
        this.secondaryCodeDescriptions = secondaryCodeDescriptions;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TableData withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Integer getEfb() {
        return efb;
    }

    public void setEfb(Integer efb) {
        this.efb = efb;
    }

    public TableData withEfb(Integer efb) {
        this.efb = efb;
        return this;
    }

    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public TableData withFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
        return this;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public TableData withBase(String base) {
        this.base = base;
        return this;
    }

    public String getBaseDescription() {
        return baseDescription;
    }

    public void setBaseDescription(String baseDescription) {
        this.baseDescription = baseDescription;
    }

    public TableData withBaseDescription(String baseDescription) {
        this.baseDescription = baseDescription;
        return this;
    }

    public Object getBaseShade() {
        return baseShade;
    }

    public void setBaseShade(Object baseShade) {
        this.baseShade = baseShade;
    }

    public TableData withBaseShade(Object baseShade) {
        this.baseShade = baseShade;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TableData withStatus(String status) {
        this.status = status;
        return this;
    }

    public Object getCtuId() {
        return ctuId;
    }

    public void setCtuId(Object ctuId) {
        this.ctuId = ctuId;
    }

    public TableData withCtuId(Object ctuId) {
        this.ctuId = ctuId;
        return this;
    }

    public Object getFuelUpload() {
        return fuelUpload;
    }

    public void setFuelUpload(Object fuelUpload) {
        this.fuelUpload = fuelUpload;
    }

    public TableData withFuelUpload(Object fuelUpload) {
        this.fuelUpload = fuelUpload;
        return this;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public TableData withComment(Object comment) {
        this.comment = comment;
        return this;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public TableData withLat(String lat) {
        this.lat = lat;
        return this;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public TableData withLon(String lon) {
        this.lon = lon;
        return this;
    }

    public Integer getHeading() {
        return heading;
    }

    public void setHeading(Integer heading) {
        this.heading = heading;
    }

    public TableData withHeading(Integer heading) {
        this.heading = heading;
        return this;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public TableData withAltitude(Integer altitude) {
        this.altitude = altitude;
        return this;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public TableData withSpeed(Integer speed) {
        this.speed = speed;
        return this;
    }

    public Boolean getHasHistory() {
        return hasHistory;
    }

    public void setHasHistory(Boolean hasHistory) {
        this.hasHistory = hasHistory;
    }

    public TableData withHasHistory(Boolean hasHistory) {
        this.hasHistory = hasHistory;
        return this;
    }

    public String getCtuDates() {
        return ctuDates;
    }

    public void setCtuDates(String ctuDates) {
        this.ctuDates = ctuDates;
    }

    public TableData withCtuDates(String ctuDates) {
        this.ctuDates = ctuDates;
        return this;
    }

    public Object getReservationId() {
        return reservationId;
    }

    public void setReservationId(Object reservationId) {
        this.reservationId = reservationId;
    }

    public TableData withReservationId(Object reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public TableData withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }



}
