# JAVA

FROM debian:bullseye

ENV POSTGRES_USER=admin \
    POSTGRES_PASSWORD=admin123 \
    POSTGRES_DB=gaiadatabase \
    PGADMIN_DEFAULT_EMAIL=admin@admin.com \
    PGADMIN_DEFAULT_PASSWORD=admin123

# Instalar dependências
RUN apt-get update && \
    apt-get install -y wget curl gnupg2 lsb-release apt-transport-https ca-certificates software-properties-common

# Instalar PostgreSQL
RUN echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list && \
    wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | apt-key add - && \
    apt-get update && \
    apt-get install -y postgresql-16

# Instalar pgAdmin 4
RUN curl https://www.pgadmin.org/static/packages_pgadmin_org.pub | apt-key add && \
    echo "deb https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list && \
    apt-get update && \
    apt-get install -y pgadmin4-web apache2

# Configurar pgAdmin
RUN /usr/pgadmin4/bin/setup-web.sh --yes

# Criar volume e diretórios necessários
VOLUME ["/var/lib/postgresql/data"]

# Expõe as portas padrão: pgAdmin (80) e PostgreSQL (5432)
EXPOSE 80 5432

# Iniciar PostgreSQL e Apache (pgAdmin)
CMD service postgresql start && \
    service apache2 start && \
    tail -f /dev/null
