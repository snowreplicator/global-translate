package com.snowreplicator.global.translate.en;

import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Enumeration;
import java.util.ResourceBundle;

@Component(
        immediate = true,
        property = {"language.id=en_US"},
        service = ResourceBundle.class
)
public class GlobalTranslatePortletEn extends ResourceBundle {

    private static final Log log = LogFactoryUtil.getLog(GlobalTranslatePortletEn.class);
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("content.Language", UTF8Control.INSTANCE);

    @Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED)
    private ModuleServiceLifecycle dataInitialized;

    @Activate
    public void activate() {
        if (log.isInfoEnabled()) {
            log.info("--- Global translate portlet en_US activated. ---");
        }
    }

    @Override
    public Enumeration<String> getKeys() {
        return resourceBundle.getKeys();
    }

    @Override
    protected Object handleGetObject(String key) {
        return resourceBundle.getObject(key);
    }

}