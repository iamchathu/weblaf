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

package com.alee.utils.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * Java 18 compatible field helper.
 *
 * @author Alexandr Zernov
 */
public final class FieldHelper
{
    private static final Field MODIFIERS;

    static
    {
        try
        {
            final Method declaredFieldMethod = Arrays.stream ( Class.class.getDeclaredMethods () )
                    .filter ( it -> Objects.equals ( it.getName (), "getDeclaredFields0" ) )
                    .findAny ()
                    .orElseThrow ();
            declaredFieldMethod.setAccessible ( true );
            final Field[] declaredFieldsOfField = ( Field[] ) declaredFieldMethod.invoke ( Field.class, false );
            MODIFIERS = Arrays.stream ( declaredFieldsOfField )
                    .filter ( it -> Objects.equals ( it.getName (), "modifiers" ) )
                    .findAny ().orElseThrow ();
        }
        catch ( final IllegalAccessException | InvocationTargetException ex )
        {
            if ( ex instanceof InvocationTargetException )
            {
                throw new RuntimeException ( ( ( InvocationTargetException ) ex ).getTargetException () );
            }
            throw new RuntimeException ( ex );
        }
    }

    /**
     * Changes {@link Field} modifiers.
     * Be aware that this is not supported JDK feature and only used in some hacky cases.
     *
     * @param field     {@link Field}
     * @param modifiers new {@link Field} modifiers
     * @throws IllegalAccessException if field is inaccessible
     */
    public static void setFieldModifiers ( final Field field, final int modifiers ) throws IllegalAccessException
    {
        MODIFIERS.setAccessible ( true );
        MODIFIERS.set ( field, modifiers );
    }
}