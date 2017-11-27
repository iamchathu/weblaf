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

package com.alee.laf.optionpane;

import com.alee.managers.style.*;
import com.alee.painter.Paintable;
import com.alee.painter.Painter;

import javax.swing.*;
import java.awt.*;

/**
 * {@link JOptionPane} extension class.
 * It contains various useful methods to simplify core component usage.
 *
 * This component should never be used with a non-Web UIs as it might cause an unexpected behavior.
 * You could still use that component even if WebLaF is not your application LaF as this component will use Web-UI in any case.
 *
 * @author Mikle Garin
 * @see JOptionPane
 * @see WebOptionPaneUI
 * @see OptionPanePainter
 */

public class WebOptionPane extends JOptionPane implements Styleable, Paintable, ShapeMethods, MarginMethods, PaddingMethods
{
    /**
     * Constructs new option pane.
     */
    public WebOptionPane ()
    {
        super ();
    }

    /**
     * Constructs new option pane.
     *
     * @param message message
     */
    public WebOptionPane ( final Object message )
    {
        this ( StyleId.auto, message );
    }

    /**
     * Constructs new option pane.
     *
     * @param message     message
     * @param messageType message type
     */
    public WebOptionPane ( final Object message, final int messageType )
    {
        this ( StyleId.auto, message, messageType );
    }

    /**
     * Constructs new option pane.
     *
     * @param message     message
     * @param messageType message type
     * @param optionType  option pane type
     */
    public WebOptionPane ( final Object message, final int messageType, final int optionType )
    {
        this ( StyleId.auto, message, messageType, optionType );
    }

    /**
     * Constructs new option pane.
     *
     * @param message     message
     * @param messageType message type
     * @param optionType  option pane type
     * @param icon        option pane icon
     */
    public WebOptionPane ( final Object message, final int messageType, final int optionType, final Icon icon )
    {
        this ( StyleId.auto, message, messageType, optionType, icon );
    }

    /**
     * Constructs new option pane.
     *
     * @param message     message
     * @param messageType message type
     * @param optionType  option pane type
     * @param icon        option pane icon
     * @param options     available options
     */
    public WebOptionPane ( final Object message, final int messageType, final int optionType, final Icon icon, final Object[] options )
    {
        this ( StyleId.auto, message, messageType, optionType, icon, options );
    }

    /**
     * Constructs new option pane.
     *
     * @param message      message
     * @param messageType  message type
     * @param optionType   option pane type
     * @param icon         option pane icon
     * @param options      available options
     * @param initialValue initial value
     */
    public WebOptionPane ( final Object message, final int messageType, final int optionType, final Icon icon, final Object[] options,
                           final Object initialValue )
    {
        this ( StyleId.auto, message, messageType, optionType, icon, options, initialValue );
    }

    /**
     * Constructs new option pane.
     *
     * @param id style ID
     */
    public WebOptionPane ( final StyleId id )
    {
        this ( id, "JOptionPane message" );
    }

    /**
     * Constructs new option pane.
     *
     * @param id      style ID
     * @param message message
     */
    public WebOptionPane ( final StyleId id, final Object message )
    {
        this ( id, message, PLAIN_MESSAGE );
    }

    /**
     * Constructs new option pane.
     *
     * @param id          style ID
     * @param message     message
     * @param messageType message type
     */
    public WebOptionPane ( final StyleId id, final Object message, final int messageType )
    {
        this ( id, message, messageType, DEFAULT_OPTION );
    }

    /**
     * Constructs new option pane.
     *
     * @param id          style ID
     * @param message     message
     * @param messageType message type
     * @param optionType  option pane type
     */
    public WebOptionPane ( final StyleId id, final Object message, final int messageType, final int optionType )
    {
        this ( id, message, messageType, optionType, null );
    }

    /**
     * Constructs new option pane.
     *
     * @param id          style ID
     * @param message     message
     * @param messageType message type
     * @param optionType  option pane type
     * @param icon        option pane icon
     */
    public WebOptionPane ( final StyleId id, final Object message, final int messageType, final int optionType, final Icon icon )
    {
        this ( id, message, messageType, optionType, icon, null );
    }

    /**
     * Constructs new option pane.
     *
     * @param id          style ID
     * @param message     message
     * @param messageType message type
     * @param optionType  option pane type
     * @param icon        option pane icon
     * @param options     available options
     */
    public WebOptionPane ( final StyleId id, final Object message, final int messageType, final int optionType, final Icon icon,
                           final Object[] options )
    {
        this ( id, message, messageType, optionType, icon, options, null );
    }

    /**
     * Constructs new option pane.
     *
     * @param id           style ID
     * @param message      message
     * @param messageType  message type
     * @param optionType   option pane type
     * @param icon         option pane icon
     * @param options      available options
     * @param initialValue initial value
     */
    public WebOptionPane ( final StyleId id, final Object message, final int messageType, final int optionType, final Icon icon,
                           final Object[] options, final Object initialValue )
    {
        super ( message, messageType, optionType, icon, options, initialValue );
        setStyleId ( id );
    }

    @Override
    public StyleId getDefaultStyleId ()
    {
        return StyleId.optionpane;
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

    /**
     * Returns the look and feel (LaF) object that renders this component.
     *
     * @return the {@link WebOptionPaneUI} object that renders this component
     */
    @Override
    public WebOptionPaneUI getUI ()
    {
        return ( WebOptionPaneUI ) super.getUI ();
    }

    /**
     * Sets the LaF object that renders this component.
     *
     * @param ui {@link WebOptionPaneUI}
     */
    public void setUI ( final WebOptionPaneUI ui )
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