#version 330

void main()
{
    gl_FragDepth = gl_FragCoord.z;
}

float calcShadow(vec4 position)
{
    float shadowFactor = 1.0;
    vec3 projCoords = position.xyz;
    // Transform from screen coordinates to texture coordinates
    projCoords = projCoords * 0.5 + 0.5;
    if ( projCoords.z < texture(shadowMap, projCoords.xy).r )
    {
        // Current fragment is not in shade
        shadowFactor = 0;
    }

    return 1 - shadowFactor;
}

float shadow = calcShadow(mlightviewVertexPos);
fragColor = clamp(ambientC * vec4(ambientLight, 1) + diffuseSpecularComp * shadow, 0, 1);