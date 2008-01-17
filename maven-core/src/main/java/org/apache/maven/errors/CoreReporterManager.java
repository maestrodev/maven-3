package org.apache.maven.errors;

import org.apache.maven.project.error.ProjectReporterManager;

public final class CoreReporterManager
{

    private static CoreErrorReporter reporter;

    private CoreReporterManager()
    {
    }

    public static CoreErrorReporter getReporter()
    {
        if ( reporter == null )
        {
            reporter = new DefaultCoreErrorReporter();
            // FIXME: Is this correct? What might this isolate and make inaccessible in a running system?
            ProjectReporterManager.setReporter( reporter );
        }

        return reporter;
    }

    public static void setReporter( CoreErrorReporter instance )
    {
        reporter = instance;
        ProjectReporterManager.setReporter( instance );
    }

    public static void clearReporter()
    {
        reporter = null;
    }

}