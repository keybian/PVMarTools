
package com.kp.martuls.dao.entitys;

import com.fasterxml.jackson.annotation.JsonValue;


public enum Status
{

    /** Valide. */
    VALIDE("V"),
    /** anticipe. */
    ANTICIPE("A"),
    /** obsolete. */
    OBSOLETE("O"),
    /** In valide. */
    INVALIDE("I");

    /** label. */
    private String label;

    /**
     * Instanciation de ind validite.
     *
     * @param label indiciateur validité.
     */
    private Status(String label)
    {
        this.label = label;
    }

    /**
     * methode Find by label : indiciateur validité.
     *
     * @param byLabel indiciateur validité.
     * @return ind validite
     */
    public static Status findByLabel(String byLabel)
    {
        for (Status i : Status.values())
        {
            if (i.label.equalsIgnoreCase(byLabel))
            {
                return i;
            }
        }
        return null;
    }

    /**
     * Accesseur de l attribut label.
     *
     * @return label
     */
    @JsonValue
    public String getLabel()
    {
        return label;
    }

}
