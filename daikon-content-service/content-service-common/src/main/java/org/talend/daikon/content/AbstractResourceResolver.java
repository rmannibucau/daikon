package org.talend.daikon.content;

import static java.util.Arrays.stream;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.ResourcePatternResolver;

public abstract class AbstractResourceResolver implements ResourceResolver {

    private final ResourcePatternResolver delegate;

    private final IONotifications notifications = new IONotifications();

    public AbstractResourceResolver(ResourcePatternResolver delegate) {
        this.delegate = delegate;
    }

    @Override
    public DeletableResource[] getResources(String locationPattern) throws IOException {
        final Resource[] resources = delegate.getResources(locationPattern);
        return stream(resources) //
                .map(resource -> convert((WritableResource) resource)) //
                .collect(Collectors.toList()) //
                .toArray(new DeletableResource[0]);
    }

    @Override
    public DeletableResource getResource(String location) {
        final DeletableResource convert = convert((WritableResource) delegate.getResource(location));
        return new DeletableResource() {
            public void delete() throws IOException {
                convert.delete();
                notifications.notifyDelete(this, convert.getFile().getUsableSpace());
            }

            public void move(String location) throws IOException {
                convert.move(location);
            }

            public boolean isWritable() {
                return convert.isWritable();
            }

            public OutputStream getOutputStream() throws IOException {
                return new MeteredOutputStream(convert.getOutputStream(), () -> {
                    return notifications.notifyAdd(this, getVolume());
                });
            }

            public boolean exists() {
                return convert.exists();
            }

            public boolean isReadable() {
                return convert.isReadable();
            }

            public boolean isOpen() {
                return convert.isOpen();
            }

            public URL getURL() throws IOException {
                return convert.getURL();
            }

            public URI getURI() throws IOException {
                return convert.getURI();
            }

            public File getFile() throws IOException {
                return convert.getFile();
            }

            public long contentLength() throws IOException {
                return convert.contentLength();
            }

            public long lastModified() throws IOException {
                return convert.lastModified();
            }

            public Resource createRelative(String relativePath) throws IOException {
                return convert.createRelative(relativePath);
            }

            public String getFilename() {
                return convert.getFilename();
            }

            public String getDescription() {
                return convert.getDescription();
            }

            public InputStream getInputStream() throws IOException {
                return convert.getInputStream();
            }
        };
    }

    protected abstract DeletableResource convert(WritableResource writableResource);

    @Override
    public ClassLoader getClassLoader() {
        return delegate.getClassLoader();
    }
}
