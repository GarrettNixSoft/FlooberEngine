#version 140

in vec2 textureCoords;
out vec4 out_Color;
uniform sampler2D colourTexture;

void main() {

	out_Color = texture(colourTexture, textureCoords);

}
