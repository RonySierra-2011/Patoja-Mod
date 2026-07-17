# Perrita Mod (Minecraft Forge 1.21.10)

Agrega **Perrita**, una mascota nueva que se comporta EXACTAMENTE igual
que el Lobo de Minecraft:

- ✅ Se puede alimentar con carne (crudos, aumenta salud/regenera)
- ✅ Se doma dándole huesos (con probabilidad aleatoria, igual que el lobo)
- ✅ Se le puede poner correa
- ✅ Se le puede poner etiqueta de nombre (name tag)
- ✅ Se sienta/para con clic derecho una vez domesticada
- ✅ Ataca a mobs hostiles para defender a su dueño
- ✅ Se teletransporta al dueño si se queda muy atrás

Técnicamente esto se logra porque `PerritaEntity` **extiende directamente
la clase `Wolf` vanilla** — toda esa lógica ya viene incluida gratis,
solo le dimos su propio `EntityType`, modelo/renderer y textura.

## ⚠️ Sobre la textura

Incluí una textura **placeholder** (un color base tostado/negro) solo para
que el mod compile y la puedas ver en el juego. Para que se vea igual a tu
imagen de referencia (perrita café con manchas negras estilo bloques),
tienes que reemplazar este archivo con el diseño real:

```
src/main/resources/assets/perritamod/textures/entity/perrita/perrita.png
```

Debe medir **64x32 px** (mismo tamaño y mapeo UV que la textura del lobo
vanilla `wolf.png`). La forma más fácil de editarla:

1. Instala **Blockbench** (blockbench.net, gratis).
2. Abre un proyecto nuevo → "Minecraft Skin/Entity" → carga el modelo del
   lobo (`Wolf`) como referencia de UV.
3. Usa tu imagen (`1784245798731_image.png`) como guía de colores/manchas
   y pinta directamente sobre la plantilla UV del lobo.
4. Exporta como PNG 64x32 y reemplaza el archivo de arriba.

## Cómo generar el .jar

### Opción A: Automático con GitHub Actions (recomendado)

1. Crea un repositorio nuevo en GitHub.
2. Sube esta carpeta completa (`git init`, `git add .`, `git commit`,
   `git remote add origin <tu-repo>`, `git push`).
3. En cuanto hagas push a `main`, la pestaña **Actions** de tu repo
   compilará el mod automáticamente.
4. Cuando termine (ícono verde ✅), entra al workflow → al final vas a
   ver el artefacto **"perrita-mod-jar"** para descargar directamente
   el `.jar` ya compilado.

### Opción B: Compilar en tu propia PC

Requisitos: JDK 21 instalado.

```bash
./gradlew build
```

(si no tienes el wrapper generado, corre primero `gradle wrapper` con
Gradle 8.10 instalado). El `.jar` final queda en `build/libs/`.

## Instalar el mod

1. Instala **Minecraft Forge 60.1.0 para 1.21.10** (forge instaler desde
   files.minecraftforge.net).
2. Copia el `.jar` generado dentro de la carpeta `mods` de tu instalación
   de Minecraft.
3. Abre el juego con el perfil de Forge, ve al inventario creativo y
   busca el **"Huevo de generación de Perrita"**, o usa el comando:
   ```
   /summon perritamod:perrita
   ```

## Estructura del proyecto

```
src/main/java/com/perritamod/
├── PerritaMod.java          → clase principal, registra todo
├── entity/
│   ├── ModEntities.java     → registro del EntityType y el spawn egg
│   └── PerritaEntity.java   → la entidad (extiende Wolf)
└── client/
    └── ModClientEvents.java → renderer + textura personalizada
```
