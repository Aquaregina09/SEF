package sef.module9.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of a Radar
 */
public class RadarImpl implements Radar {

    /**
     * Constructs a new Radar
     */
    List<RadarContact> radarContact;

    public RadarImpl() {
        this.radarContact = new ArrayList<>();
    }

    /*
     * (non-Javadoc)
     * @see
     * sef.module8.activity.Radar#addContact(sef.module8.activity.RadarContact)
     */

    public RadarContact addContact(RadarContact contact) {
        List<RadarContact> tempRadarContact = null;
        RadarContact tempContact = contact;
        boolean isSimilar = false;
        int counter;
        if (contact == null) {
            return tempContact;
        }

        for (counter = 0; counter < this.getContactCount(); counter++) {
            if (radarContact.get(counter).getContactID().equals(contact.getContactID())) {

                radarContact.get(counter).setBearing(contact.getBearing());

                radarContact.get(counter).setDistance(contact.getDistance());

                isSimilar = true;

                break;

            }
        }

        if (!isSimilar) {
            radarContact.add(tempContact);

        }

        return tempContact;
    }

    /*
     * (non-Javadoc)
     * @see sef.module8.activity.Radar#getContact(java.lang.String)
     */
    public RadarContact getContact(String id) {

        if (id == null || id.equals(""))
            return null;

        RadarContact tempContact = null;

        for (RadarContact contact : radarContact) {
            if (contact.getContactID().equals(id)) {
                tempContact = contact;
                break;
            }
        }

        return tempContact;
    }

    /*
     * (non-Javadoc)
     * @see sef.module8.activity.Radar#getContactCount()
     */
    public int getContactCount() {

        return this.radarContact.size();
    }

    /*
     * (non-Javadoc)
     * @see sef.module8.activity.Radar#removeContact(java.lang.String)
     */
    public RadarContact removeContact(String id) {
        if (id == null || id.equals(""))
            return null;

        RadarContact tempContact = null;

        for (RadarContact contact : radarContact) {
            if (contact.getContactID().equals(id)) {
                tempContact = contact;
                radarContact.remove(contact);
            }
        }

        return tempContact;

    }

    /*
     * (non-Javadoc)
     * @see sef.module8.activity.Radar#returnContacts()
     */
    public List<RadarContact> returnContacts() {
        List<RadarContact> tempRadarContact = new ArrayList<>();
        tempRadarContact.addAll(radarContact);
        return tempRadarContact;
    }

    /*
     * (non-Javadoc)
     * @see sef.module8.activity.Radar#returnContacts(java.util.Comparator)
     */
    public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {

        // return null;
        Collections.sort(radarContact, comparator);
        List<RadarContact> sub = new ArrayList<>();

        sub.addAll(radarContact);

        return sub;

    }

}
