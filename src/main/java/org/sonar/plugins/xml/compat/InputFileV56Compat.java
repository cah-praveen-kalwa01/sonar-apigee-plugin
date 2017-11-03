/*
 * SonarQube XML Plugin
 * Copyright (C) 2010-2017 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.xml.compat;

import java.nio.charset.Charset;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;

/**
 * Makes the wrapped API 5.6+ InputFile instance compatible with API 6.0,
 * by providing the charset() method.
 */
class InputFileV56Compat extends InputFileV60Compat {

  private final Charset charset;

  InputFileV56Compat(InputFile wrapped, SensorContext context) {
    super(wrapped);
    this.charset = context.fileSystem().encoding();
  }

  @Override
  public Charset charset() {
    return charset;
  }
}
