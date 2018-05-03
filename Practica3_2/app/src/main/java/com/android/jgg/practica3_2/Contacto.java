package com.android.jgg.practica3_2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Contacto implements Parcelable {
    private String name;
    private Date   fecha;
    private String mail;
    private String tfno;
    private String desc;


    public Contacto() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTfno() {
        return tfno;
    }

    public void setTfno(String tfno) {
        this.tfno = tfno;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    protected Contacto(Parcel in) {
        name = in.readString();
        long tmpFecha = in.readLong();
        fecha = tmpFecha != -1 ? new Date(tmpFecha) : null;
        tfno = in.readString();
        mail = in.readString();
        desc = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(fecha != null ? fecha.getTime() : -1L);
        dest.writeString(tfno);
        dest.writeString(mail);
        dest.writeString(desc);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Contacto> CREATOR = new Parcelable.Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };
}