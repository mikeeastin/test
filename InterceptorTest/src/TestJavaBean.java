// Copyright (c) 1998-2013 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2013-XX-XX, Mike.Mai, creation
// ============================================================================

/**
 * @author Mike.Mai
 */
public class TestJavaBean {

    private String id;

    private String name;

    private int age;

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    public String getName() {

        return name;

    }

    public void setName(final String name) {

        this.name = name;

    }

    public int getAge() {

        return age;

    }

    public void setAge(final int age) {

        this.age = age;

    }

}
