/*
 * This file is part of WebLookAndFeel library.
 *
 * WebLookAndFeel library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * WebLookAndFeel library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with WebLookAndFeel library.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.alee.laf.splitpane;

import com.alee.managers.hotkey.HotkeyData;
import com.alee.managers.language.DictionaryListener;
import com.alee.managers.language.LanguageEventMethods;
import com.alee.managers.language.LanguageListener;
import com.alee.managers.language.UILanguageManager;
import com.alee.managers.settings.DefaultValue;
import com.alee.managers.settings.SettingsMethods;
import com.alee.managers.settings.SettingsProcessor;
import com.alee.managers.settings.UISettingsManager;
import com.alee.managers.style.*;
import com.alee.painter.Paintable;
import com.alee.painter.Painter;
import com.alee.utils.swing.MouseButton;
import com.alee.utils.swing.extensions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * {@link JSplitPane} extension class.
 * It contains various useful methods to simplify core component usage.
 *
 * This component should never be used with a non-Web UIs as it might cause an unexpected behavior.
 * You could still use that component even if WebLaF is not your application LaF as this component will use Web-UI in any case.
 *
 * @author Mikle Garin
 * @see JSplitPane
 * @see WebSplitPaneUI
 * @see SplitPanePainter
 */

public class WebSplitPane extends JSplitPane
        implements Styleable, Paintable, ShapeMethods, MarginMethods, PaddingMethods, EventMethods, LanguageEventMethods, SettingsMethods
{
    /**
     * Constructs new split pane.
     */
    public WebSplitPane ()
    {
        this ( StyleId.auto );
    }

    /**
     * Constructs new split pane.
     *
     * @param orientation split pane orientation
     */
    public WebSplitPane ( final int orientation )
    {
        this ( StyleId.auto, orientation );
    }

    /**
     * Constructs new split pane.
     *
     * @param orientation      split pane orientation
     * @param continuousLayout whether or not split pane should redraw continuously as the divider changes position
     */
    public WebSplitPane ( final int orientation, final boolean continuousLayout )
    {
        this ( StyleId.auto, orientation, continuousLayout );
    }

    /**
     * Constructs new split pane.
     *
     * @param orientation    split pane orientation
     * @param leftComponent  left split component
     * @param rightComponent right split component
     */
    public WebSplitPane ( final int orientation, final Component leftComponent, final Component rightComponent )
    {
        this ( StyleId.auto, orientation, leftComponent, rightComponent );
    }

    /**
     * Constructs new split pane.
     *
     * @param orientation      split pane orientation
     * @param continuousLayout whether or not split pane should redraw continuously as the divider changes position
     * @param leftComponent    left split component
     * @param rightComponent   right split component
     */
    public WebSplitPane ( final int orientation, final boolean continuousLayout, final Component leftComponent,
                          final Component rightComponent )
    {
        this ( StyleId.auto, orientation, continuousLayout, leftComponent, rightComponent );
    }

    /**
     * Constructs new split pane.
     *
     * @param id style ID
     */
    public WebSplitPane ( final StyleId id )
    {
        this ( id, HORIZONTAL_SPLIT, true, null, null );
    }

    /**
     * Constructs new split pane.
     *
     * @param id          style ID
     * @param orientation split pane orientation
     */
    public WebSplitPane ( final StyleId id, final int orientation )
    {
        this ( id, orientation, true, null, null );
    }

    /**
     * Constructs new split pane.
     *
     * @param id               style ID
     * @param orientation      split pane orientation
     * @param continuousLayout whether or not split pane should redraw continuously as the divider changes position
     */
    public WebSplitPane ( final StyleId id, final int orientation, final boolean continuousLayout )
    {
        this ( id, orientation, continuousLayout, null, null );
    }

    /**
     * Constructs new split pane.
     *
     * @param id             style ID
     * @param orientation    split pane orientation
     * @param leftComponent  left split component
     * @param rightComponent right split component
     */
    public WebSplitPane ( final StyleId id, final int orientation, final Component leftComponent, final Component rightComponent )
    {
        this ( id, orientation, true, leftComponent, rightComponent );
    }

    /**
     * Constructs new split pane.
     *
     * @param id               style ID
     * @param orientation      split pane orientation
     * @param continuousLayout whether or not split pane should redraw continuously as the divider changes position
     * @param leftComponent    left split component
     * @param rightComponent   right split component
     */
    public WebSplitPane ( final StyleId id, final int orientation, final boolean continuousLayout, final Component leftComponent,
                          final Component rightComponent )
    {
        super ( orientation, continuousLayout, leftComponent, rightComponent );
        setStyleId ( id );
    }

    /**
     * Returns proportional split divider location.
     *
     * @return proportional split divider location
     */
    public double getProportionalDividerLocation ()
    {
        final int l = getOrientation () == WebSplitPane.HORIZONTAL_SPLIT ? getWidth () : getHeight ();
        return Math.max ( 0.0, Math.min ( ( double ) getDividerLocation () / ( l - getDividerSize () ), 1.0 ) );
    }

    /**
     * Adds divider listener.
     *
     * @param listener divider listener to add
     */
    public void addDividerListener ( final ComponentListener listener )
    {
        getUI ().getDivider ().addComponentListener ( listener );
    }

    /**
     * Removes divider listener.
     *
     * @param listener divider listener to remove
     */
    public void removeDividerListener ( final ComponentListener listener )
    {
        getUI ().getDivider ().removeComponentListener ( listener );
    }

    @Override
    public StyleId getDefaultStyleId ()
    {
        return StyleId.splitpane;
    }

    @Override
    public StyleId getStyleId ()
    {
        return StyleManager.getStyleId ( this );
    }

    @Override
    public StyleId setStyleId ( final StyleId id )
    {
        return StyleManager.setStyleId ( this, id );
    }

    @Override
    public StyleId resetStyleId ()
    {
        return StyleManager.resetStyleId ( this );
    }

    @Override
    public Skin getSkin ()
    {
        return StyleManager.getSkin ( this );
    }

    @Override
    public Skin setSkin ( final Skin skin )
    {
        return StyleManager.setSkin ( this, skin );
    }

    @Override
    public Skin setSkin ( final Skin skin, final boolean recursively )
    {
        return StyleManager.setSkin ( this, skin, recursively );
    }

    @Override
    public Skin resetSkin ()
    {
        return StyleManager.resetSkin ( this );
    }

    @Override
    public void addStyleListener ( final StyleListener listener )
    {
        StyleManager.addStyleListener ( this, listener );
    }

    @Override
    public void removeStyleListener ( final StyleListener listener )
    {
        StyleManager.removeStyleListener ( this, listener );
    }

    @Override
    public Painter getCustomPainter ()
    {
        return StyleManager.getCustomPainter ( this );
    }

    @Override
    public Painter setCustomPainter ( final Painter painter )
    {
        return StyleManager.setCustomPainter ( this, painter );
    }

    @Override
    public boolean resetCustomPainter ()
    {
        return StyleManager.resetCustomPainter ( this );
    }

    @Override
    public Shape getShape ()
    {
        return ShapeMethodsImpl.getShape ( this );
    }

    @Override
    public Insets getMargin ()
    {
        return MarginMethodsImpl.getMargin ( this );
    }

    @Override
    public void setMargin ( final int margin )
    {
        MarginMethodsImpl.setMargin ( this, margin );
    }

    @Override
    public void setMargin ( final int top, final int left, final int bottom, final int right )
    {
        MarginMethodsImpl.setMargin ( this, top, left, bottom, right );
    }

    @Override
    public void setMargin ( final Insets margin )
    {
        MarginMethodsImpl.setMargin ( this, margin );
    }

    @Override
    public Insets getPadding ()
    {
        return PaddingMethodsImpl.getPadding ( this );
    }

    @Override
    public void setPadding ( final int padding )
    {
        PaddingMethodsImpl.setPadding ( this, padding );
    }

    @Override
    public void setPadding ( final int top, final int left, final int bottom, final int right )
    {
        PaddingMethodsImpl.setPadding ( this, top, left, bottom, right );
    }

    @Override
    public void setPadding ( final Insets padding )
    {
        PaddingMethodsImpl.setPadding ( this, padding );
    }

    @Override
    public MouseAdapter onMousePress ( final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onMousePress ( this, runnable );
    }

    @Override
    public MouseAdapter onMousePress ( final MouseButton mouseButton, final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onMousePress ( this, mouseButton, runnable );
    }

    @Override
    public MouseAdapter onMouseEnter ( final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onMouseEnter ( this, runnable );
    }

    @Override
    public MouseAdapter onMouseExit ( final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onMouseExit ( this, runnable );
    }

    @Override
    public MouseAdapter onMouseDrag ( final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onMouseDrag ( this, runnable );
    }

    @Override
    public MouseAdapter onMouseDrag ( final MouseButton mouseButton, final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onMouseDrag ( this, mouseButton, runnable );
    }

    @Override
    public MouseAdapter onMouseClick ( final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onMouseClick ( this, runnable );
    }

    @Override
    public MouseAdapter onMouseClick ( final MouseButton mouseButton, final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onMouseClick ( this, mouseButton, runnable );
    }

    @Override
    public MouseAdapter onDoubleClick ( final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onDoubleClick ( this, runnable );
    }

    @Override
    public MouseAdapter onMenuTrigger ( final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onMenuTrigger ( this, runnable );
    }

    @Override
    public KeyAdapter onKeyType ( final KeyEventRunnable runnable )
    {
        return EventMethodsImpl.onKeyType ( this, runnable );
    }

    @Override
    public KeyAdapter onKeyType ( final HotkeyData hotkey, final KeyEventRunnable runnable )
    {
        return EventMethodsImpl.onKeyType ( this, hotkey, runnable );
    }

    @Override
    public KeyAdapter onKeyPress ( final KeyEventRunnable runnable )
    {
        return EventMethodsImpl.onKeyPress ( this, runnable );
    }

    @Override
    public KeyAdapter onKeyPress ( final HotkeyData hotkey, final KeyEventRunnable runnable )
    {
        return EventMethodsImpl.onKeyPress ( this, hotkey, runnable );
    }

    @Override
    public KeyAdapter onKeyRelease ( final KeyEventRunnable runnable )
    {
        return EventMethodsImpl.onKeyRelease ( this, runnable );
    }

    @Override
    public KeyAdapter onKeyRelease ( final HotkeyData hotkey, final KeyEventRunnable runnable )
    {
        return EventMethodsImpl.onKeyRelease ( this, hotkey, runnable );
    }

    @Override
    public FocusAdapter onFocusGain ( final FocusEventRunnable runnable )
    {
        return EventMethodsImpl.onFocusGain ( this, runnable );
    }

    @Override
    public FocusAdapter onFocusLoss ( final FocusEventRunnable runnable )
    {
        return EventMethodsImpl.onFocusLoss ( this, runnable );
    }

    @Override
    public MouseAdapter onDragStart ( final int shift, final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onDragStart ( this, shift, runnable );
    }

    @Override
    public MouseAdapter onDragStart ( final int shift, final MouseButton mouseButton, final MouseEventRunnable runnable )
    {
        return EventMethodsImpl.onDragStart ( this, shift, mouseButton, runnable );
    }

    @Override
    public void addLanguageListener ( final LanguageListener listener )
    {
        UILanguageManager.addLanguageListener ( this, listener );
    }

    @Override
    public void removeLanguageListener ( final LanguageListener listener )
    {
        UILanguageManager.removeLanguageListener ( this, listener );
    }

    @Override
    public void removeLanguageListeners ()
    {
        UILanguageManager.removeLanguageListeners ( this );
    }

    @Override
    public void addDictionaryListener ( final DictionaryListener listener )
    {
        UILanguageManager.addDictionaryListener ( this, listener );
    }

    @Override
    public void removeDictionaryListener ( final DictionaryListener listener )
    {
        UILanguageManager.removeDictionaryListener ( this, listener );
    }

    @Override
    public void removeDictionaryListeners ()
    {
        UILanguageManager.removeDictionaryListeners ( this );
    }

    @Override
    public void registerSettings ( final String key )
    {
        UISettingsManager.registerComponent ( this, key );
    }

    @Override
    public <T extends DefaultValue> void registerSettings ( final String key, final Class<T> defaultValueClass )
    {
        UISettingsManager.registerComponent ( this, key, defaultValueClass );
    }

    @Override
    public void registerSettings ( final String key, final Object defaultValue )
    {
        UISettingsManager.registerComponent ( this, key, defaultValue );
    }

    @Override
    public void registerSettings ( final String group, final String key )
    {
        UISettingsManager.registerComponent ( this, group, key );
    }

    @Override
    public <T extends DefaultValue> void registerSettings ( final String group, final String key, final Class<T> defaultValueClass )
    {
        UISettingsManager.registerComponent ( this, group, key, defaultValueClass );
    }

    @Override
    public void registerSettings ( final String group, final String key, final Object defaultValue )
    {
        UISettingsManager.registerComponent ( this, group, key, defaultValue );
    }

    @Override
    public void registerSettings ( final String key, final boolean loadInitialSettings, final boolean applySettingsChanges )
    {
        UISettingsManager.registerComponent ( this, key, loadInitialSettings, applySettingsChanges );
    }

    @Override
    public <T extends DefaultValue> void registerSettings ( final String key, final Class<T> defaultValueClass,
                                                            final boolean loadInitialSettings, final boolean applySettingsChanges )
    {
        UISettingsManager.registerComponent ( this, key, defaultValueClass, loadInitialSettings, applySettingsChanges );
    }

    @Override
    public void registerSettings ( final String key, final Object defaultValue, final boolean loadInitialSettings,
                                   final boolean applySettingsChanges )
    {
        UISettingsManager.registerComponent ( this, key, defaultValue, loadInitialSettings, applySettingsChanges );
    }

    @Override
    public <T extends DefaultValue> void registerSettings ( final String group, final String key, final Class<T> defaultValueClass,
                                                            final boolean loadInitialSettings, final boolean applySettingsChanges )
    {
        UISettingsManager.registerComponent ( this, group, key, defaultValueClass, loadInitialSettings, applySettingsChanges );
    }

    @Override
    public void registerSettings ( final String group, final String key, final Object defaultValue, final boolean loadInitialSettings,
                                   final boolean applySettingsChanges )
    {
        UISettingsManager.registerComponent ( this, group, key, defaultValue, loadInitialSettings, applySettingsChanges );
    }

    @Override
    public void registerSettings ( final SettingsProcessor settingsProcessor )
    {
        UISettingsManager.registerComponent ( this, settingsProcessor );
    }

    @Override
    public void unregisterSettings ()
    {
        UISettingsManager.unregisterComponent ( this );
    }

    @Override
    public void loadSettings ()
    {
        UISettingsManager.loadSettings ( this );
    }

    @Override
    public void saveSettings ()
    {
        UISettingsManager.saveSettings ( this );
    }

    /**
     * Returns the look and feel (LaF) object that renders this component.
     *
     * @return the {@link WSplitPaneUI} object that renders this component
     */
    @Override
    public WSplitPaneUI getUI ()
    {
        return ( WSplitPaneUI ) super.getUI ();
    }

    /**
     * Sets the LaF object that renders this component.
     *
     * @param ui {@link WSplitPaneUI}
     */
    public void setUI ( final WSplitPaneUI ui )
    {
        super.setUI ( ui );
    }

    @Override
    public void updateUI ()
    {
        StyleManager.getDescriptor ( this ).updateUI ( this );
    }

    @Override
    public String getUIClassID ()
    {
        return StyleManager.getDescriptor ( this ).getUIClassId ();
    }
}