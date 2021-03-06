/*
 * Copyright (c) 2017. Paul E. Tinius
 */

package io.github.tinius.cloud.util;

import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;

/**
 * Determines the MIME type of a file. This is currently not a very
 * robust implementation. Using this method the mime type is determined
 * based on the file extension, and the mapping comes from the file
 * content-types.properties under the lib/ directory of the running JRE
 *
 * @author: Bill Branan
 * Date: May 7, 2010
 *
 * Modified by @author ptinius
 */
public class DiscreteTypeUtil
{
    private static final String DEFAULT_MIME_TYPE = "application/octet-stream";

    private FileNameMap fileNameMap = URLConnection.getFileNameMap( );

    /**
     * @param file the file
     *
     * @return Returns the {@link String} representation of the MIME TYPE
     */
    public String getMimeType( final File file )
    {
        if ( file == null )
        {
            return DEFAULT_MIME_TYPE;
        }
        else
        {
            return getMimeType( file.getName( ) );
        }
    }

    /**
     * @param fileName the name of the file
     *
     * @return Returns the {@link String} representation of the MIME TYPE
     */
    public String getMimeType( String fileName )
    {
        if ( fileName == null )
        {
            return DEFAULT_MIME_TYPE;
        }

        final String mimeType = fileNameMap.getContentTypeFor( fileName );
        if ( mimeType == null )
        {
            return DEFAULT_MIME_TYPE;
        }
        else
        {
            return mimeType;
        }
    }

}
