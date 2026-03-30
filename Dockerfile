# --- Stage 1: Build the game ---
FROM gradle:8.5-jdk21 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew clean jproDist --no-daemon

# --- Stage 2: Run the game on Hugging Face ---
FROM eclipse-temurin:21-jre
RUN useradd -m -u 1000 user
USER user
ENV HOME=/home/user
WORKDIR $HOME/app

COPY --from=builder --chown=user /app/build/install/Cardflow .

EXPOSE 7860

CMD ["bin/Cardflow"]