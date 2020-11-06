package com.wt.fryChicken.kitchen.cooker;

public enum Operate {
    FRY,
    TEMPLATE_PROTECT, LOW_TEMPLATE, HIGH_TEMPLATE,
    FROZEN,UNFROZEN,
    NO_SURGE,LOW_SURGE,MID_SURGE,HIGH_SURGE, NORMAL_SURGE
    ;

    public boolean isTemplateOnly(Operate operate) {
        return operate == TEMPLATE_PROTECT || operate == LOW_TEMPLATE || operate == HIGH_TEMPLATE;
    }

}
