FROM postgres:latest

ENV POSTGRES_USER root
ENV POSTGRES_PASSWORD root
ENV POSTGRES_DB sectorsync

VOLUME /var/lib/postgresql/data

EXPOSE 5432