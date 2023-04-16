package org.observerPattern;

import org.Product.Product;

public interface Observer {
    void update(Product product);

    public String getName();

    public void setName(String name);

    public String getEmail();

    public void setEmail(String email);

}
